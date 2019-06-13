package org.lle.biblio.consumer.contract.dao;

import org.lle.biblio.model.bean.utilisateur.Utilisateur;
import org.lle.biblio.model.exception.NotFoundException;


/**
 * Interface de DAO pour le package « utilisateur »
 */
public interface UtilisateurDao {


    Utilisateur getUtilisateur(String login, String password ) throws NotFoundException;

    Utilisateur getUtilisateur(Integer pId ) throws NotFoundException;
}
