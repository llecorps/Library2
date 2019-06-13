package org.lle.biblio.business.contract.manager;

import org.lle.biblio.model.bean.livre.Livre;
import org.lle.biblio.model.exception.NotFoundException;

import java.util.List;

/**
 * Created by TheAdmin on 30.01.2019.
 */
public interface LivreManager {

    Livre getLivre (int id);
    List<Livre> getListLivre() throws NotFoundException;
    List<Livre> getResultLivre(String chaine) throws NotFoundException;
}
