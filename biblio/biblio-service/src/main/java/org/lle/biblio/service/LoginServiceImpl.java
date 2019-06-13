package org.lle.biblio.service;

import org.lle.biblio.model.bean.utilisateur.Utilisateur;

import javax.inject.Named;

@Named
public class LoginServiceImpl extends AbstractService {

  public Utilisateur doLogin(String login, String password){

        Utilisateur vUtilisateur = getManagerFactory().getUtilisateurManager().getUtilisateur(login,password);

        return vUtilisateur;

    }


}