package org.lle.biblio.business.impl;

import org.lle.biblio.business.contract.BusinessProxy;
import org.lle.biblio.business.contract.manager.AuteurManager;
import org.lle.biblio.business.contract.manager.LivreManager;
import org.lle.biblio.business.contract.manager.LocationManager;
import org.lle.biblio.business.contract.manager.UtilisateurManager;
import org.lle.biblio.business.impl.manager.*;
import org.lle.biblio.consumer.contract.dao.DaoProxy;


/**
 * <p>Implémentation du Proxy d'accès à la couche Business.</p>
 */
public class BusinessProxyImpl implements BusinessProxy {

    // ==================== Attributs Static ====================
    /** Le Proxy d'accès à la couche Consumer-DAO */
    private static DaoProxy daoProxy;


    // ==================== Attributs ====================
    /** The Comptabilite manager. */

    private UtilisateurManager utilisateurManager = new UtilisateurManagerImpl();
    private LocationManager locationManager = new LocationManagerImpl();
    private LivreManager livreManager = new LivreManagerImpl();
    private AuteurManager auteurManager = new AuteurManagerImpl();


    // ==================== Constructeurs ====================
    /** Instance unique de la classe (design pattern Singleton) */
    private static final BusinessProxyImpl INSTANCE = new BusinessProxyImpl();

    /**
     * Renvoie l'instance unique de la classe (design pattern Singleton).
     *
     * @return {@link BusinessProxyImpl}
     */
    protected static BusinessProxyImpl getInstance() {
        if (daoProxy == null) {
            throw new UnsatisfiedLinkError("La classe BusinessProxyImpl n'a pas été initialisée.");
        }
        return BusinessProxyImpl.INSTANCE;
    }

    /**
     * Renvoie l'instance unique de la classe (design pattern Singleton).
     *
     * @param pDaoProxy -
     * @param pTransactionManager -
     * @return {@link BusinessProxyImpl}
     */
    public static BusinessProxyImpl getInstance(DaoProxy pDaoProxy,
                                                TransactionManager pTransactionManager) {
        daoProxy = pDaoProxy;
        AbstractBusinessManager.configure(BusinessProxyImpl.INSTANCE, pDaoProxy, pTransactionManager);
        return BusinessProxyImpl.INSTANCE;
    }

    /**
     * Constructeur.
     */
    protected BusinessProxyImpl() {
        super();
    }


    // ==================== Getters/Setters ====================


    @Override
    public UtilisateurManager getUtilisateurManager() {
        return utilisateurManager;
    }

    @Override
    public LocationManager getLocationManager() {
        return locationManager;
    }

    @Override
    public LivreManager getLivreManager() {
        return livreManager;
    }

    @Override
    public AuteurManager getAuteurManager() {
        return auteurManager;
    }
}
