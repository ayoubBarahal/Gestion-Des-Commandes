package BuisnessLogic;

import Model.Commande;
import Model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UtilisateurManager {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("GestionCommandes");

    public void ShowUtilisateur() {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            List<Utilisateur> utilisateurs=em.createQuery("select u from Utilisateur u", Utilisateur.class).getResultList();
            System.out.println("--------------------------  Utilisateur List  --------------------------------");
            for(Utilisateur utilisateur : utilisateurs){
                System.out.println("Code de l\'Utilisateur : "+utilisateur.getCodeut()+"\t Nom  : "+utilisateur.getNomut()+" Prenom : "+utilisateur.getPrenomut()+"\t Fonction "+utilisateur.getFonction());
            }
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println("Failed to show Utilisateur list");
        }
        finally{
            em.close();
        }

    }

    public void CreateUtilisateur(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(utilisateur);
            em.getTransaction().commit();
            System.out.println("User Add Successfully ");
        }
        catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("Failed to Add User");
        }
        finally{
            em.close();
        }

    }

    public void UpdateUtilisateur(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(utilisateur);
            em.getTransaction().commit();
            System.out.println("Utilisateur updated Successfully ");
        }
        catch(Exception e){
            System.out.println("Failed to Update Utilisateur");
        }
        finally{
            em.close();
        }

    }
    public void DeleteUtilisateur(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Utilisateur existingUser = em.find(Utilisateur.class, utilisateur.getCodeut());
            if (existingUser != null) {
                em.remove(existingUser);
                em.getTransaction().commit();
                System.out.println("User deleted successfully");
            } else {
                System.out.println("User not found, cannot delete");
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Failed to delete User: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
