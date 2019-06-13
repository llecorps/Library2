package org.lle.biblio.consumer.impl;

import org.lle.biblio.consumer.contract.DaoFactory;
import org.lle.biblio.consumer.contract.dao.AuteurDao;
import org.lle.biblio.consumer.contract.dao.LivreDao;
import org.lle.biblio.consumer.contract.dao.LocationDao;
import org.lle.biblio.consumer.contract.dao.UtilisateurDao;

import javax.inject.Inject;
import javax.inject.Named;


@Named
public class DaoFactoryImpl implements DaoFactory {


    @Inject
    private LocationDao locationDao;
    @Override
    public LocationDao getLocationDao() {
        return locationDao;
    }

    @Inject
    private LivreDao livreDao;
    @Override
    public LivreDao getLivreDao() {
        return livreDao;
    }

    @Inject
    private AuteurDao auteurDao;
    @Override
    public AuteurDao getAuteurDao() {
        return auteurDao;
    }

    @Inject
    private UtilisateurDao utilisateurDao;
    @Override
    public UtilisateurDao getUtilisateurDao() {
        return utilisateurDao;
    }
}
