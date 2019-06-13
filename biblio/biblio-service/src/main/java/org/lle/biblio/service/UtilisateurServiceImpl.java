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
}
