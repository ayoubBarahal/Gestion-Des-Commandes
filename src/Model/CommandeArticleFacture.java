package Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CommandeArticleFacture")
public class CommandeArticleFacture {

    @Id
    private CAF idCAF;
    private int Qtecom ;

    public CommandeArticleFacture(int Numcom,int Numfact, int Codeart , int qtecom) {
        this.idCAF = new CAF(Numcom,Numfact,Codeart);
        Qtecom = qtecom;
    }

    public CommandeArticleFacture() {

    }
    public CAF getIdCAF() {
        return idCAF;
    }
    public void setIdCAF(CAF idCAF) {
        this.idCAF = idCAF;
    }
    public double getQtecom() {
        return Qtecom;
    }
    public void setQtecom(int qtecom) {
        Qtecom = qtecom;
    }


}
