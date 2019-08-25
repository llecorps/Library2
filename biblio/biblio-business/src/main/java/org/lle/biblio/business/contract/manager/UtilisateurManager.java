package org.lle.biblio.business.contract.manager;

import org.lle.biblio.model.bean.utilisateur.Utilisateur;

import java.util.List;

/**
 * Created by TheAdmin on 19.01.2019.
 */
public interface UtilisateurManager {


    List<Utilisateur> getListUtilisateur();

    Utilisateur getUtilisateur(String Login, String Password);
    Utilisateur getUtilisateur(int id);
    void delRecall (int id);
    void addRecall (int id);
    boolean getRecall(int id);
}
