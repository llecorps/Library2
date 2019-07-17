package org.lle.biblio.consumer.contract;

        import org.lle.biblio.consumer.contract.dao.AuteurDao;
        import org.lle.biblio.consumer.contract.dao.LivreDao;
        import org.lle.biblio.consumer.contract.dao.LocationDao;
        import org.lle.biblio.consumer.contract.dao.UtilisateurDao;


public interface DaoFactory {



    UtilisateurDao getUtilisateurDao();

    LocationDao getLocationDao();

    LivreDao getLivreDao();

    AuteurDao getAuteurDao();
}
