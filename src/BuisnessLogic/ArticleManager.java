package BuisnessLogic;

import Model.Article;
import Model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ArticleManager {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("GestionCommandes");

    public void ShowArticle() {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            List<Article> articles=em.createQuery("select art from Article art", Article.class).getResultList();
            System.out.println("--------------------------  Articles List  --------------------------------");
            for(Article article : articles){
                System.out.println("Code de l\'article : "+article.getCodeart()+"\t Description  : "+article.getDesart()+"\t Couleur : "+article.getCouleur()+"\t Puart "+article.getPuart()+"\t Quantité de Stock est : "+article.getQtestock());
            }
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println("Failed to show Articles list");
        }
        finally{
            em.close();
        }

    }

    public void CreateArticle(Article article) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(article);
            em.getTransaction().commit();
            System.out.println("Article Add Successfully ");
        }
        catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("Failed to Add Article");
        }
        finally{
            em.close();
        }

    }

    public void UpdateArticle(Article Article) {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(Article);
            em.getTransaction().commit();
            System.out.println("Article updated Successfully ");
        }
        catch(Exception e){
            System.out.println("Failed to Update Article");
        }
        finally{
            em.close();
        }

    }
    public void DeleteArticle(Article article) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Article existingArticle = em.find(Article.class, article.getCodeart());
            if (existingArticle != null) {
                em.remove(existingArticle);
                em.getTransaction().commit();
                System.out.println("Article deleted successfully");
            } else {
                System.out.println("Article not found, cannot delete");
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Failed to delete Article: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
