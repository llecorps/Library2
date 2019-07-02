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

    List<Booking> getListReservation(int id);

    void addProlo(String expiration, int id);

    void addBooked(Booking pBooking);

    void delBooked(int id);
}
