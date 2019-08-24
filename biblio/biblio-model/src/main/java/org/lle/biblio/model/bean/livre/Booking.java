package org.lle.biblio.model.bean.livre;

/**
 * Created by TheAdmin on 13.01.2019.
 */
public class Booking {

    private int id;
    private int user_id;
    private int livre_id;
    private String bookingdate;
    private int position;
    private String notification;

    public Booking() {
    }

    public Booking(int id, int user_id, int livre_id, String bookingdate, int position, String notification) {
        this.id = id;
        this.user_id = user_id;
        this.livre_id = livre_id;
        this.bookingdate = bookingdate;
        this.position = position;
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLivre_id() {
        return livre_id;
    }

    public void setLivre_id(int livre_id) {
        this.livre_id = livre_id;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", livre_id=" + livre_id +
                ", bookingdate='" + bookingdate + '\'' +
                ", position=" + position +
                ", notification='" + notification + '\'' +
                '}';
    }
}
