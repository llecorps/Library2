package org.lle.biblio.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;
import org.lle.biblio.model.bean.emprunt.Emprunt;
import org.lle.biblio.webapp.generated.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by TheAdmin on 06.02.2019.
 */
public class DisplayAction extends ActionSupport implements SessionAware {

    private Integer id;
    private Livre livre;
    private Auteur auteur;
    private String login;
    private List<Location> listLocation;
    private List<Emprunt> listEmprunt;
    private Utilisateur utilisateur;
    private String prolongation;

    public String getProlongation() {
        return prolongation;
    }

    public void setProlongation(String prolongation) {
        this.prolongation = prolongation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Location> getListLocation() {
        return listLocation;
    }

    public void setListLocation(List<Location> listLocation) {
        this.listLocation = listLocation;
    }

    public List<Emprunt> getListEmprunt() {
        return listEmprunt;
    }

    public void setListEmprunt(List<Emprunt> listEmprunt) {
        this.listEmprunt = listEmprunt;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Map<String, Object> session;


    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    public String doDisplay() {

        String vResult = ActionSupport.INPUT;

        BiblioService_Service pBiblio = new BiblioService_Service();
        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

         utilisateur = (Utilisateur) this.session.get("utilisateur");

        if(utilisateur !=null){

            listLocation = pBiblioService.getListLocation(utilisateur.getId());
            listEmprunt = new ArrayList<Emprunt>();

            for (Location loc : listLocation){

                Emprunt vEmprunt = new Emprunt();

                livre = pBiblioService.getLivre(loc.getLivreId());
                auteur = pBiblioService.getAuteur(livre.getAuteurId());

                vEmprunt.setTitre(livre.getTitre());
                vEmprunt.setDescription(livre.getDescription());
                vEmprunt.setGenre(livre.getGenre());
                vEmprunt.setExpiredate(loc.getExpiredate());
                vEmprunt.setNom(auteur.getNom());
                vEmprunt.setId(livre.getId());

                if (loc.isProlongation() == true){
                    vEmprunt.setProlongation("true");
                }else{
                    vEmprunt.setProlongation("false");
                }

                listEmprunt.add(vEmprunt);

            }
            vResult = ActionSupport.SUCCESS;

        }else{
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }
}
