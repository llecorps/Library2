package org.lle.biblio.business.impl;

import org.lle.biblio.business.contract.ManagerFactory;
import org.lle.biblio.business.contract.manager.AuteurManager;
import org.lle.biblio.business.contract.manager.LivreManager;
import org.lle.biblio.business.contract.manager.LocationManager;
import org.lle.biblio.business.contract.manager.UtilisateurManager;

import javax.inject.Inject;
import javax.inject.Named;


@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private UtilisateurManager utilisateurManager;
    @Override
    public UtilisateurManager getUtilisateurManager() {
        return this.utilisateurManager;
    }
    public void setUtilisateurManager(UtilisateurManager pUtilisateurManager) {
        utilisateurManager = pUtilisateurManager;
    }

    @Inject
    private LocationManager locationManager;
    @Override
    public LocationManager getLocationManager() {
        return locationManager;
    }
    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }

    @Inject
    private LivreManager livremanager;
    @Override
    public LivreManager getLivreManager() {
        return this.livremanager;
    }
    public void setLivremanager(LivreManager livremanager) {
        this.livremanager = livremanager;
    }

    @Inject
    private AuteurManager auteurmanager;
    @Override
    public AuteurManager getAuteurManager() {
        return this.auteurmanager;
    }
    public void setAuteurmanager(AuteurManager auteurmanager) {
        this.auteurmanager = auteurmanager;
    }

}
