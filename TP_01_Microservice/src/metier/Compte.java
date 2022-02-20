
package metier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

@XmlRootElement(name="compte") // veut dire qu'on veut retourner notre objet java en XML, cad on veut utiliser
//JaxB
@XmlAccessorType(XmlAccessType.FIELD) //On dit a jaxB qu'on veut utiliser les annotations jaxB directement sur
// les attributs, sinon on va devoir les rajouter dans les getters et setters
public class Compte {
    private Long code;
    private double solde;
    @XmlTransient // cad qu'on veut pas sérialiser la date dans le retour xml
    private Date dateCreation;

    public Compte() {
    }
    public Compte(Long code, double solde, Date datecreation){
        this.code = code;
        this.solde = solde;
        this.dateCreation = datecreation;
    }
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }



}
