package Model;

import javax.persistence.*;

@Entity
@Table(name = "Article")
public class Article {
    @Id
    private int Codeart;
    private String Desart;
    private String Couleur;
    private Double Puart;
    private double Qtestock ;

    public Article(int codeart, String desart, String couleur, double puart, double qtestock) {
        Codeart = codeart;
        Desart = desart;
        Couleur = couleur;
        Puart = puart;
        Qtestock = qtestock;
    }

    public Article() {

    }
    public int getCodeart() {
        return Codeart;
    }
    public void setCodeart(int codeart) {
        Codeart = codeart;
    }
    public String getDesart() {
        return Desart;
    }
    public void setDesart(String desart) {
        Desart = desart;
    }
    public String getCouleur() {
        return Couleur;
    }
    public void setCouleur(String couleur) {
        Couleur = couleur;
    }
    public double getPuart() {
        return Puart;
    }
    public void setPuart(double puart) {
        Puart = puart;
    }
    public double getQtestock() {
        return Qtestock;
    }
    public void setQtestock(double qtestock) {
        Qtestock = qtestock;
    }
}
