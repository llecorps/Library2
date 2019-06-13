package org.lle.biblio.service;

import org.lle.biblio.model.bean.location.Location;

import java.util.List;

/**
 * Created by TheAdmin on 28.01.2019.
 */
public class LocationServiceImpl extends AbstractService{

    private int id;

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

    public List<Location> listLocation(){

        List<Location> vListLocation = getManagerFactory().getLocationManager().listLocation();

        return vListLocation;
    }

    public void addProlo ( String expiration, int id){

        getManagerFactory().getLocationManager().addProlo(expiration,id);

    }
}
