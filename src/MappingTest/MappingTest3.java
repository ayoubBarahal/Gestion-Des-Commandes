package MappingTest;

import BuisnessLogic.ArticleManager;
import BuisnessLogic.CAFManager;
import Model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MappingTest3 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Client client=new Client(5,"Mongoule","Younes","Hay Houda , AGADIR ","068562851661");
        Date date = dateFormat.parse("01-01-2025");
        Commande commande=new Commande(1,date,client);
        Utilisateur utilisateur=new Utilisateur(1,"BARAHAL","AYOUB","ENG");
        Facture facture=new Facture(1,date,5000,utilisateur);

        ArticleManager articleManager=new ArticleManager();
        Article article=new Article(1,"Mercedes AMG GLC350","Black",900000,5000);
        articleManager.CreateArticle(article);
        article.setQtestock(1500);
        articleManager.UpdateArticle(article);
        articleManager.ShowArticle();
        articleManager.DeleteArticle(article);

        CAFManager cafManager=new CAFManager();
        CommandeArticleFacture caf=new CommandeArticleFacture(facture.getNumfact(), commande.getNumcom(), article.getCodeart(), 50);
        cafManager.CreateCAF(caf);
        caf.setQtecom(59);
        cafManager.UpdateCommandeArticleFacture(caf);
        cafManager.ShowCAF();
        cafManager.DeleteCommandeArticleFacture(caf);


    }
}
