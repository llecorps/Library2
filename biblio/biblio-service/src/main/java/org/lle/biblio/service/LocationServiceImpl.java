package org.lle.biblio.service;

import org.lle.biblio.model.bean.livre.Booking;
import org.lle.biblio.model.bean.location.Location;
import org.lle.biblio.model.bean.utilisateur.Utilisateur;
import org.lle.biblio.model.exception.NotFoundException;

import java.util.List;

/**
 * Created by TheAdmin on 28.01.2019.
 */
public class LocationServiceImpl extends AbstractService{

    private int id;
    private Utilisateur user;
    private Booking booking;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation(int id){

        Location vLocation = getManagerFactory().getLocationManager().getLocation(id);
        return vLocation;
    }
    public Location getLivrelocation(int id){

        Location vLocation = getManagerFactory().getLocationManager().getLivrelocation(id);
        return vLocation;
    }

    public int getExemplaire(int id){

        int vExemplaire = getManagerFactory().getLocationManager().getExemplaire(id);
        return vExemplaire;
    }

    public void addEmprunt(Location pLocation){

        getManagerFactory().getLocationManager().addEmprunt(pLocation);
        }

    public List<Location> getListLocation(int id){

        List<Location> vListLocation = getManagerFactory().getLocationManager().getListLocation(id);

        return vListLocation;
    }

    public List<Booking> getListReservation(int id){

        List<Booking> vListReservation = getManagerFactory().getLocationManager().getListReservation(id);

        return vListReservation;
    }


    public List<Location> listLocation(){

        List<Location> vListLocation = getManagerFactory().getLocationManager().listLocation();

        return vListLocation;
    }

    public List<Booking> listBooking(){

        List<Booking> vListBooking = getManagerFactory().getLocationManager().listBooking();

        return vListBooking;
    }

    public int getNbreLocation(int id){

        int vNbreLocation = getManagerFactory().getLocationManager().getNbreLocation(id);

        return vNbreLocation;
    }

    public int getPosition(int id){

        int vPosition = getManagerFactory().getLocationManager().getPosition(id);

        return vPosition;
    }

    public String getExpiredate(int id){

        String vExpiredate = getManagerFactory().getLocationManager().getExpiredate(id);

        return vExpiredate;
    }

    public void addProlo ( String expiration, int id){

        getManagerFactory().getLocationManager().addProlo(expiration,id);

    }
    public void addBooked (Booking pBooking){

        getManagerFactory().getLocationManager().addBooked(pBooking);

    }
    public void delBooked (int id){

        getManagerFactory().getLocationManager().delBooked(id);

    }
    public void delLoc (Location location){

         getManagerFactory().getLocationManager().delLoc(location);

    }

    public Booking userPosition(int id) throws NotFoundException {

        booking = getManagerFactory().getLocationManager().userPosition(id);

        return booking;
    }

    public Utilisateur getUtilisateur(int id) {

            user = getManagerFactory().getUtilisateurManager().getUtilisateur(id);

        return user;

    }
    public void addNotif(String date, int id) {

        getManagerFactory().getLocationManager().addNotif(date , id);

    }
}
