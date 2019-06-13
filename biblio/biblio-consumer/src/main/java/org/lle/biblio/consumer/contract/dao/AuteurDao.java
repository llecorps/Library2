package org.lle.biblio.consumer.contract.dao;

import org.lle.biblio.model.bean.auteur.Auteur;
import org.lle.biblio.model.exception.NotFoundException;

/**
 * Created by TheAdmin on 31.01.2019.
 */
public interface AuteurDao {

    Auteur getAuteur (int id) throws NotFoundException;

}
