package Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Commande")
public class Commande {
    @Id
    private int Numcom ;
    private Date Datecom;
    @ManyToOne
    @JoinColumn(name="Numcl")
    private Client Client ;


    public Commande(int numcom, Date datecom,Client client) {
        Numcom = numcom;
        Datecom = datecom;
        Client = client;
    }
    public Commande() {

    }
    public int getNumcom() {
        return Numcom;
    }
    public void setNumcom(int numcom) {
        Numcom = numcom;
    }
    public Date getDatecom() {
        return Datecom;
    }
    public void setDatecom(Date datecom) {
        Datecom = datecom;
    }

    public Client getClient() {
        return Client;
    }
}
