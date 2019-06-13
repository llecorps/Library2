package org.lle.biblio.business.impl.manager;

import org.lle.biblio.business.contract.manager.LivreManager;
import org.lle.biblio.model.bean.livre.Livre;
import org.lle.biblio.model.exception.NotFoundException;

import javax.inject.Named;
import java.util.List;

/**
 * Created by TheAdmin on 30.01.2019.
 */
@Named
public class LivreManagerImpl extends AbstractManager implements LivreManager {

    private Livre vLivre;
    private List<Livre> vListLivre;

    @Override
    public Livre getLivre(int id) {

        try {
            vLivre = getDaoFactory().getLivreDao().getLivre(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return vLivre;
    }

    @Override
    public List<Livre> getListLivre() throws NotFoundException {
        vListLivre = getDaoFactory().getLivreDao().getListLivre();

        return vListLivre;
    }

    @Override
    public List<Livre> getResultLivre(String chaine) throws NotFoundException {
        vListLivre = getDaoFactory().getLivreDao().getResultLivre(chaine);
        return vListLivre;
    }

}
