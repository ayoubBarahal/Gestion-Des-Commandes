package BuisnessLogic;

import Model.Facture;
import Model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FactureManager {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("GestionCommandes");

    public void ShowFacture() {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            List<Facture> factures=em.createQuery("select f from Facture f", Facture.class).getResultList();
            System.out.println("--------------------------  Factures List  --------------------------------");
            for(Facture facture : factures){
                System.out.println("Num de Facture : "+facture.getNumfact()+"\t Date  : "+facture.getDatefact()+" Montant : "+facture.getMontant());
            }
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println("Failed to show Factures list");
        }
        finally{
            em.close();
        }

    }

    public void CreateFacture(Facture facture) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(facture);
            em.getTransaction().commit();
            System.out.println("Facture Add Successfully ");
        }
        catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("Failed to Add Facture");
        }
        finally{
            em.close();
        }

    }

    public void UpdateFacture(Facture facture) {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(facture);
            em.getTransaction().commit();
            System.out.println("facture updated Successfully ");
        }
        catch(Exception e){
            System.out.println("Failed to Update facture");
        }
        finally{
            em.close();
        }

    }
    public void DeleteFacture(Facture facture) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Facture existingFacture = em.find(Facture.class, facture.getNumfact());
            if (existingFacture != null) {
                em.remove(existingFacture);
                em.getTransaction().commit();
                System.out.println("Facture deleted successfully");
            } else {
                System.out.println("Facture not found, cannot delete");
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Facture to delete User: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
