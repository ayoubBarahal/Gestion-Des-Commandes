package Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CAF implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "Numcom")
    private int Numcom;
    @Column(name = "Numfact")
    private int Numfact;
    @Column(name="Codeart")
    private int Codeart;

    public CAF(int numcom, int numfact, int codeart) {
        Numcom = numcom;
        Numfact = numfact;
        Codeart = codeart;
    }
    public CAF() {

    }
    public int getNumfact() {
        return Numfact;
    }
    public void setNumfact(int numfact) {
        Numfact = numfact;
    }
    public int getNumcom() {
        return Numcom;
    }
    public void setNumcom(int numcom) {
        Numcom = numcom;
    }
    public int getCodeart() {
        return Codeart;
    }
    public void setCodeart(int codeart) {
        Codeart = codeart;
    }


}
