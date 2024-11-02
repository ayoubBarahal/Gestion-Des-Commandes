package Model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Facture")
public class Facture {
    @Id
    private int Numfact ;
    private Date Datefact ;
    private double Montant ;
    @ManyToOne
    @JoinColumn(name = "Codeut")
    private Utilisateur utilisateur ;


    public Facture(int numfact, Date datefact, double montant,Utilisateur utilisateur) {
        Numfact = numfact;
        Datefact = datefact;
        Montant = montant;
        this.utilisateur = utilisateur;
    }

    public Facture() {

    }
    public int getNumfact() {
        return Numfact;
    }
    public void setNumfact(int numfact) {
        Numfact = numfact;
    }
    public Date getDatefact() {
        return Datefact;
    }
    public void setDatefact(Date datefact) {
        Datefact = datefact;
    }
    public double getMontant() {
        return Montant;
    }
    public void setMontant(double montant) {
        Montant = montant;
    }


    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
