package org.lle.biblio.business.impl.manager;

import org.lle.biblio.business.contract.manager.AuteurManager;
import org.lle.biblio.model.bean.auteur.Auteur;
import org.lle.biblio.model.exception.NotFoundException;

import javax.inject.Named;

/**
 * Created by TheAdmin on 31.01.2019.
 */
@Named
public class AuteurManagerImpl extends AbstractManager implements AuteurManager{

    private Auteur vAuteur;

    @Override
    public Auteur getAuteur(int id) {
        try {
            vAuteur = getDaoFactory().getAuteurDao().getAuteur(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return vAuteur;
    }

}
