package MappingTest;

import BuisnessLogic.ClientManager;
import BuisnessLogic.CommandeManager;
import Model.Client;
import Model.Commande;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MappingTest1 {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        ClientManager clientManager = new ClientManager();
        Client client=new Client(5,"Mongoule","Younes","Hay Houda , AGADIR ","068562851661");
        clientManager.CreateClient( client);
        client.setAdressecl("Saint Denis , PARIS");
        clientManager.UpdateClient(client);
        clientManager.ShowClient();
//        clientManager.DeleteClient(client);

        Date date = dateFormat.parse("01-01-2025");


        CommandeManager commandeManager = new CommandeManager();
        Commande commande=new Commande(1,date,client);

        commandeManager.CreateCommande(commande);

        Date date2 = dateFormat.parse("01-05-2025");
        commande.setDatecom(date2);
        commandeManager.UpdateCommande(commande);
        commandeManager.ShowCommande();
        commandeManager.DeleteCommande(commande);


    }
}
