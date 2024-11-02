package BuisnessLogic;

import Model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.ClientInfoStatus;
import java.util.List;

public class ClientManager {


    EntityManagerFactory emf= Persistence.createEntityManagerFactory("GestionCommandes");

    public void ShowClient() {
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            List<Client> clients=em.createQuery("select c from Client c",Client.class).getResultList();
            System.out.println("--------------------------  Client --------------------------------");
            for(Client client : clients){
                System.out.println("ID : "+client.getNumcl()+"\t Nom : "+client.getNomcl()+"\t Prenom : "+client.getPrenomcl()+"\t Adresse : "+client.getAdressecl()+"\t Tel :"+client.getTelcl());
            }
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println("Failed to show client list");
        }
        finally{
            emf.close();
        }

    }

    public void CreateClient(Client client){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
            System.out.println("Client created Successfully ");
        }
        catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("Failed to Create Client");
        }
        finally {
            em.close();
        }
    }

    public void UpdateClient(Client client){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(client);
            em.getTransaction().commit();
            System.out.println("Client updated Successfully ");
        }
        catch(Exception e){
            System.out.println("Failed to Update Client");
        }
        finally {
            em.close();
        }

    }

    public void DeleteClient(Client client){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
                em.remove(client);
                em.getTransaction().commit();
                System.out.println("Client deleted Successfully ");
        }
        catch(Exception e){
//            em.getTransaction().rollback();
            System.out.println("Failed to Delete Client");
        }
        finally {
            em.close();        }


    }


}
