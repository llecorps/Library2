package org.lle.biblio.consumer.contract.dao;

import org.lle.biblio.model.bean.livre.Livre;
import org.lle.biblio.model.exception.NotFoundException;

import java.util.List;

/**
 * Created by TheAdmin on 30.01.2019.
 */
public interface LivreDao {

    Livre getLivre (int id) throws NotFoundException;
    List<Livre> getListLivre() throws NotFoundException;
    List<Livre> getResultLivre(String chaine) throws NotFoundException;
}
