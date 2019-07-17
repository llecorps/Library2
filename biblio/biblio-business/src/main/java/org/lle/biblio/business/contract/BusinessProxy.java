package org.lle.biblio.business.contract;

import org.lle.biblio.business.contract.manager.AuteurManager;
import org.lle.biblio.business.contract.manager.LivreManager;
import org.lle.biblio.business.contract.manager.LocationManager;
import org.lle.biblio.business.contract.manager.UtilisateurManager;


/**
 * <p>Interface du Proxy d'accès à la couche Business</p>
 */
public interface BusinessProxy {

    // ==================== Managers ====================

    /**
     * Renvoie le manager du package Comptabilite.
     *
     * @return ComptabiliteManager
     */
    UtilisateurManager getUtilisateurManager();

    LocationManager getLocationManager();

    LivreManager getLivreManager();

    AuteurManager getAuteurManager();
}
