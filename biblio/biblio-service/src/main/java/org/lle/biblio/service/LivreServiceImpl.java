package org.lle.biblio.service;

import org.lle.biblio.model.bean.livre.Livre;
import org.lle.biblio.model.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheAdmin on 30.01.2019.
 */
public class LivreServiceImpl extends AbstractService {




    public Livre getLivre(int id){

        Livre vLivre = getManagerFactory().getLivreManager().getLivre(id);

        return vLivre;

    }

    public Livre getLivreTitre(String chaine){

        Livre vLivre = getManagerFactory().getLivreManager().getLivreTitre(chaine);

        return vLivre;

    }

    public List<Livre> getListLivre() throws NotFoundException {

       List<Livre> vListLivre = new ArrayList();

       vListLivre = getManagerFactory().getLivreManager().getListLivre();

        return vListLivre;
    }

    public List<Livre> getResultLivre(String chaine) throws NotFoundException {

        List<Livre> vListLivre = new ArrayList();

        vListLivre = getManagerFactory().getLivreManager().getResultLivre(chaine);

        return vListLivre;
    }
}
