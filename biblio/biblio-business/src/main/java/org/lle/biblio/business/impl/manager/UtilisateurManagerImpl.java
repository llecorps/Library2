package org.lle.biblio.business.impl.manager;

/**
 * Created by TheAdmin on 19.01.2019.
 */

import org.lle.biblio.business.contract.manager.UtilisateurManager;
import org.lle.biblio.model.bean.utilisateur.Utilisateur;
import org.lle.biblio.model.exception.NotFoundException;

import javax.inject.Named;

import java.util.List;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    private Utilisateur vUtilisateur;

    @Override
    public List<Utilisateur> getListUtilisateur() {
        return null;
    }

    @Override
    public Utilisateur getUtilisateur(String pLogin, String pPassword)  {
        try {
            vUtilisateur = getDaoFactory().getUtilisateurDao().getUtilisateur(pLogin, pPassword);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return vUtilisateur;
    }

    @Override
    public Utilisateur getUtilisateur(int id) {

        try {
            vUtilisateur = getDaoFactory().getUtilisateurDao().getUtilisateur(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return vUtilisateur;

    }

    @Override
    public void delRecall(int id) {

       getDaoFactory().getUtilisateurDao().delRecall(id);
    }

    @Override
    public void addRecall(int id) {

        getDaoFactory().getUtilisateurDao().addRecall(id);
    }

    @Override
    public boolean getRecall(int id) {

        boolean vRecall = getDaoFactory().getUtilisateurDao().getRecall(id);
        return vRecall;
    }

}
