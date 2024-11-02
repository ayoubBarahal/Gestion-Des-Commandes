package BuisnessLogic;

import Model.CommandeArticleFacture;
import Model.Facture;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CAFManager {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("GestionCommandes");

    public void ShowCAF() {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            List<CommandeArticleFacture> commandeArticleFactures=em.createQuery("select caf from CommandeArticleFacture caf", CommandeArticleFacture.class).getResultList();
            System.out.println("--------------------------  Factures List  --------------------------------");
            for(CommandeArticleFacture commandeArticleFacture : commandeArticleFactures){
                System.out.println("Num de Facture : "+commandeArticleFacture.getIdCAF().getNumfact()+"\t Num de Commande  : "+commandeArticleFacture.getIdCAF().getNumcom()+" Code Article : "+commandeArticleFacture.getIdCAF().getCodeart()+" Quantité Commander"+commandeArticleFacture.getQtecom());
            }
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println("Failed to show CAF list");
        }
        finally{
            em.close();
        }

    }

    public void CreateCAF(CommandeArticleFacture commandeArticleFacture) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(commandeArticleFacture);
            em.getTransaction().commit();
            System.out.println("commandeArticleFacture Add Successfully ");
        }
        catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("Failed to commandeArticleFacture Facture");
        }
        finally{
            em.close();
        }

    }

    public void UpdateCommandeArticleFacture(CommandeArticleFacture commandeArticleFacture) {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(commandeArticleFacture);
            em.getTransaction().commit();
            System.out.println("commandeArticleFacture updated Successfully ");
        }
        catch(Exception e){
            System.out.println("Failed to Update commandeArticleFacture");
        }
        finally{
            em.close();
        }

    }
    public void DeleteCommandeArticleFacture(CommandeArticleFacture commandeArticleFacture) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            CommandeArticleFacture existingCAF = em.find(CommandeArticleFacture.class, commandeArticleFacture.getIdCAF());
            if (existingCAF != null) {
                em.remove(existingCAF);
                em.getTransaction().commit();
                System.out.println("CommandeArticleFacture deleted successfully");
            } else {
                System.out.println("CommandeArticleFacture not found, cannot delete");
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("CommandeArticleFacture to delete User: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
