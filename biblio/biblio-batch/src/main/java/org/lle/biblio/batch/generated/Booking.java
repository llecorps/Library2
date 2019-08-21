
package org.lle.biblio.batch.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for booking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="booking">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookingdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="livre_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="notification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "booking", propOrder = {
    "bookingdate",
    "id",
    "livreId",
    "notification",
    "position",
    "userId"
})
public class Booking {

    protected String bookingdate;
    protected int id;
    @XmlElement(name = "livre_id")
    protected int livreId;
    protected String notification;
    protected int position;
    @XmlElement(name = "user_id")
    protected int userId;

    /**
     * Gets the value of the bookingdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingdate() {
        return bookingdate;
    }

    /**
     * Sets the value of the bookingdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingdate(String value) {
        this.bookingdate = value;
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
     * Gets the value of the notification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotification() {
        return notification;
    }

    /**
     * Sets the value of the notification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotification(String value) {
        this.notification = value;
    }

    /**
     * Gets the value of the position property.
     * 
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     */
    public void setPosition(int value) {
        this.position = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

}
