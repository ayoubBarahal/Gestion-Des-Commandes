package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    private int Numcl;
    private String Nomcl;
    private String Prenomcl;
    private String Adressecl;
    private String Telcl;

    @OneToMany(mappedBy = "Client")
    private Set<Commande> Commande=new HashSet<Commande>();

    public Client(int numcl, String nomcl, String prenomcl, String adressecl, String telcl) {
        Numcl = numcl;
        Nomcl = nomcl;
        Prenomcl = prenomcl;
        Adressecl = adressecl;
        Telcl = telcl;
    }
    public Client() {

    }
    public int getNumcl() {
        return Numcl;
    }
    public void setNumcl(int numcl) {
        Numcl = numcl;
    }
    public String getNomcl() {
        return Nomcl;
    }
    public void setNomcl(String nomcl) {
        Nomcl = nomcl;
    }
    public String getPrenomcl() {
        return Prenomcl;
    }
    public void setPrenomcl(String prenomcl) {
        Prenomcl = prenomcl;
    }
    public String getAdressecl() {
        return Adressecl;
    }
    public void setAdressecl(String adressecl) {
        Adressecl = adressecl;
    }
    public String getTelcl() {
        return Telcl;
    }
    public void setTelcl(String telcl) {
        Telcl = telcl;
    }


}
