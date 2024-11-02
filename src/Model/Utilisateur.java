package Model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Utilisateur")
public class Utilisateur {
    @Id
    private int Codeut ;
    private String Nomut ;
    private String Prenomut ;
    private String Fonction ;
    @OneToMany(mappedBy = "utilisateur")
    private Set<Facture> Facture ;

    public Utilisateur(int codeut, String nomut, String prenomut, String fonction) {
        Codeut = codeut;
        Nomut = nomut;
        Prenomut = prenomut;
        Fonction = fonction;
    }

    public Utilisateur() {

    }
    public int getCodeut() {
        return Codeut;
    }
    public void setCodeut(int Codeut) {
        this.Codeut = Codeut;
    }
    public String getNomut() {
        return Nomut;
    }
    public void setNomut(String Nomut) {
        this.Nomut = Nomut;
    }
    public String getPrenomut() {
        return Prenomut;
    }
    public void setPrenomut(String Prenomut) {
        this.Prenomut = Prenomut;
    }
    public String getFonction() {
        return Fonction;
    }
    public void setFonction(String Fonction) {
        this.Fonction = Fonction;
    }



}
