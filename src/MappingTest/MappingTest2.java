package MappingTest;

import BuisnessLogic.FactureManager;
import BuisnessLogic.UtilisateurManager;
import Model.Facture;
import Model.Utilisateur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MappingTest2 {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        UtilisateurManager utilisateurManager = new UtilisateurManager();
        Utilisateur utilisateur=new Utilisateur(1,"BARAHAL","AYOUB","ENG");
        utilisateurManager.CreateUtilisateur(utilisateur);
        utilisateur.setFonction("ENGINEER");
        utilisateurManager.UpdateUtilisateur(utilisateur);
        utilisateurManager.ShowUtilisateur();
//        utilisateurManager.DeleteUtilisateur(utilisateur);

        Date date = dateFormat.parse("01-01-2025");

        FactureManager factureManager = new FactureManager();
        Facture facture=new Facture(1,date,5000,utilisateur);
        factureManager.CreateFacture(facture);
        facture.setMontant(6000);
        factureManager.UpdateFacture(facture);
        factureManager.ShowFacture();
        factureManager.DeleteFacture(facture);
    }
}
