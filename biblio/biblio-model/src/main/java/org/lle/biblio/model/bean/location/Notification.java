package org.lle.biblio.model.bean.location;

/**
 * Created by TheAdmin on 23.07.2019.
 */
public class Notification {

    private int id;
    private int user_id;
    private int livre_id;
    private String bookingdate;
    private int position;
    private String notification;

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

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Notification() {
    }

    public Notification(int id, int user_id, int livre_id, String bookingdate, int position, String notification) {
        this.id = id;
        this.user_id = user_id;
        this.livre_id = livre_id;
        this.bookingdate = bookingdate;
        this.position = position;
        this.notification = notification;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", livre_id=" + livre_id +
                ", bookingdate='" + bookingdate + '\'' +
                ", position=" + position +
                ", notification='" + notification + '\'' +
                '}';
    }
}
