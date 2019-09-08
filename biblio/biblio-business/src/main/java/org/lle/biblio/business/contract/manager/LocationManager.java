package org.lle.biblio.business.contract.manager;

import org.lle.biblio.model.bean.livre.Booking;
import org.lle.biblio.model.bean.location.Location;
import org.lle.biblio.model.exception.NotFoundException;

import java.util.List;

/**
 * Created by TheAdmin on 27.01.2019.
 */
public interface LocationManager {

    Location getLocation (int id);
    Location getLivrelocation (int id);
    int getExemplaire (int id);
    void addEmprunt(Location pLocation );
    List<Location> getListLocation(int id);
    List<Booking> getListReservation(int id);
    List<Location> listLocation();
    List<Booking> listBooking();
    void addProlo(String expiration, int id);
    void addBooked(Booking pBooking);
    void delBooked(int id);
    int getNbreLocation (int id);
    int getPosition (int id);
    String getExpiredate (int id);
    void delLoc(Location location);
    Booking userPosition (int id) throws NotFoundException;
    void addNotif(String date, int id);

}
