package org.lle.biblio.consumer.contract.dao;

import org.lle.biblio.model.bean.livre.Booking;
import org.lle.biblio.model.bean.location.Location;
import org.lle.biblio.model.exception.NotFoundException;

import java.util.List;

/**
 * Created by TheAdmin on 29.01.2019.
 */
public interface LocationDao {

    Location getLocation (int id) throws NotFoundException;

    Location getLivrelocation (int id) throws NotFoundException;

    int getExemplaire(int id) throws NotFoundException;

    void addEmprunt(Location pLoc);

    List<Location> getListLocation(int id);

    List<Location> listLocation();

    List<Booking> listBooking();

    List<Booking> getListReservation(int id);

    void addProlo(String expiration, int id);

    void addBooked(Booking pBooking);

    void delBooked(int id);

    int getNbreLocation (int id);

    int getPosition (int id) throws NotFoundException;

    String getExpiredate (int id);

    void delLoc(Location location);

    Booking userPosition (int id) throws NotFoundException;

    void addNotif(String date, int pId);
}
