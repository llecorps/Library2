package org.lle.biblio.service;

import org.lle.biblio.model.bean.utilisateur.Utilisateur;

/**
 * Created by TheAdmin on 21.02.2019.
 */
public class UtilisateurServiceImpl extends AbstractService {

    public Utilisateur getUtilisateur(int id){

        Utilisateur vUtilisateur = getManagerFactory().getUtilisateurManager().getUtilisateur(id);

                return vUtilisateur;
    }

    public void delRecall(int id) {

        getManagerFactory().getUtilisateurManager().delRecall(id);
    }

    public void addRecall(int id) {

        getManagerFactory().getUtilisateurManager().addRecall(id);
    }

    public boolean getRecall(int id) {

        boolean vRecall = getManagerFactory().getUtilisateurManager().getRecall(id);

        return vRecall;
    }
}
