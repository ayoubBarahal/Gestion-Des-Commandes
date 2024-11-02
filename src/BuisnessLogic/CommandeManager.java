package BuisnessLogic;

import Model.Client;
import Model.Commande;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CommandeManager {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("GestionCommandes");

    public void ShowCommande() {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            List<Commande> commandes=em.createQuery("select com from Commande com", Commande.class).getResultList();
            System.out.println("--------------------------  Commandes  --------------------------------");
            for(Commande commande : commandes){
                System.out.println("Num de Commande : "+commande.getNumcom()+"\t Date : "+commande.getDatecom()+" Associe au Client num : "+commande.getClient().getNumcl());
            }
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println("Failed to show Commandes list");
        }
        finally{
            em.close();
        }

    }

    public void CreateCommande(Commande commande) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(commande);
            em.getTransaction().commit();
            System.out.println("Commande Add Successfully ");
        }
        catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("Failed to Add Commande");
        }
        finally{
            em.close();
        }

    }

    public void UpdateCommande(Commande commande){
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(commande);
            em.getTransaction().commit();
            System.out.println("Commande updated Successfully ");
        }
        catch(Exception e){
            System.out.println("Failed to Update Commande");
        }
        finally{
            em.close();
        }

    }
    public void DeleteCommande(Commande commande) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Commande existingCommande = em.find(Commande.class, commande.getNumcom());
            if (existingCommande != null) {
                em.remove(existingCommande);
                em.getTransaction().commit();
                System.out.println("Commande deleted successfully");
            } else {
                System.out.println("Commande not found, cannot delete");
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Failed to delete commande: " + e.getMessage());
        } finally {
            em.close();
        }
    }

}
