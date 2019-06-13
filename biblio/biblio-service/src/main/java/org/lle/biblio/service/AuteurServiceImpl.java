package org.lle.biblio.service;

import org.lle.biblio.model.bean.auteur.Auteur;

/**
 * Created by TheAdmin on 31.01.2019.
 */
public class AuteurServiceImpl extends AbstractService {

    public Auteur getAuteur(int id){

        Auteur vAuteur = getManagerFactory().getAuteurManager().getAuteur(id);

        return vAuteur;

    }

}
