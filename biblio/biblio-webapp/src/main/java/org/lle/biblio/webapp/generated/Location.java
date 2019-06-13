
package org.lle.biblio.webapp.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for location complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="location">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="expiredate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="livre_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prolongation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="utilisateur_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "location", propOrder = {
    "expiredate",
    "id",
    "livreId",
    "prolongation",
    "utilisateurId"
})
public class Location {

    protected String expiredate;
    protected int id;
    @XmlElement(name = "livre_id")
    protected int livreId;
    protected boolean prolongation;
    @XmlElement(name = "utilisateur_id")
    protected int utilisateurId;

    /**
     * Gets the value of the expiredate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiredate() {
        return expiredate;
    }

    /**
     * Sets the value of the expiredate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiredate(String value) {
        this.expiredate = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the livreId property.
     * 
     */
    public int getLivreId() {
        return livreId;
    }

    /**
     * Sets the value of the livreId property.
     * 
     */
    public void setLivreId(int value) {
        this.livreId = value;
    }

    /**
     * Gets the value of the prolongation property.
     * 
     */
    public boolean isProlongation() {
        return prolongation;
    }

    /**
     * Sets the value of the prolongation property.
     * 
     */
    public void setProlongation(boolean value) {
        this.prolongation = value;
    }

    /**
     * Gets the value of the utilisateurId property.
     * 
     */
    public int getUtilisateurId() {
        return utilisateurId;
    }

    /**
     * Sets the value of the utilisateurId property.
     * 
     */
    public void setUtilisateurId(int value) {
        this.utilisateurId = value;
    }

}
