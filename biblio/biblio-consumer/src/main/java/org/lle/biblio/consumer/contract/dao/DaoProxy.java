package org.lle.biblio.consumer.contract.dao;


/**
 * Interface du Proxy d'accès à la couche DAO
 */
public interface DaoProxy {



    UtilisateurDao getUtilisateurDao();

    LocationDao getLocationDao();

    LivreDao getLivreDao();

    AuteurDao getAuteurDao();

}
