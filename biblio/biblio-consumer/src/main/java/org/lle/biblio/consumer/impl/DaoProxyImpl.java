package org.lle.biblio.consumer.impl;

import org.lle.biblio.consumer.contract.dao.*;


/**
 * <p>Implémentation du Proxy d'accès à la couche DAO.</p>
 */
public final class DaoProxyImpl implements DaoProxy {

    // ==================== Attributs ====================
    /** {@link AuteurDao} */
    private AuteurDao auteurDao;

    /** {@link LivreDao} */
    private LivreDao livreDao;

    /** {@link LocationDao} */
    private LocationDao locationDao;

    /** {@link UtilisateurDao} */
    private UtilisateurDao utilisateurDao;



    // ==================== Constructeurs ====================
    /** Instance unique de la classe (design pattern Singleton) */
    private static final DaoProxyImpl INSTANCE = new DaoProxyImpl();

    /**
     * Renvoie l'instance unique de la classe (design pattern Singleton).
     *
     * @return {@link DaoProxyImpl}
     */
    protected static DaoProxyImpl getInstance() {
        return DaoProxyImpl.INSTANCE;
    }

    /**
     * Constructeur.
     */
    private DaoProxyImpl() {
        super();
    }


    @Override
    public UtilisateurDao getUtilisateurDao() {
        return utilisateurDao;
    }
    public void setUtilisateurDao(UtilisateurDao pUtilisateurDao) {
        this.utilisateurDao = pUtilisateurDao;
    }

    @Override
    public LocationDao getLocationDao() {
        return locationDao;
    }
    public void setLocationDao(LocationDao pLocationDao) {
        this.locationDao = pLocationDao;
    }


    @Override
    public LivreDao getLivreDao() {
        return livreDao;
    }
    public void setlivreDao(LivreDao pLivreDao) {
        this.livreDao = pLivreDao;
    }

    // ==================== Getters/Setters ====================
    public AuteurDao getAuteurDao() {
        return this.auteurDao;
    }
    public void setauteurDao(AuteurDao pAuteurDao) {
        this.auteurDao = pAuteurDao;
    }
}
