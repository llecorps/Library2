package org.lle.biblio.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.lle.biblio.model.bean.emprunt.Emprunt;
import org.lle.biblio.model.exception.NotFoundException;
import org.lle.biblio.webapp.generated.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by TheAdmin on 26.01.2019.
 */
public class RechercheAction extends ActionSupport implements SessionAware {


    private List<Livre> ListLivre;
    private List<Livre> ResultLivre;
    private Livre livre;
    private Map<String, Object> session;
    private List<Location> listLocation;
    private List<Emprunt> listEmprunt;
    private Auteur auteur;
    private Emprunt emprunt;
    private int id;
    private Booking booking;
    private Utilisateur user;

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public List<Emprunt> getListEmprunt() {
        return listEmprunt;
    }

    public void setListEmprunt(List<Emprunt> listEmprunt) {
        this.listEmprunt = listEmprunt;
    }

    public List<Location> getListLocation() {
        return listLocation;
    }

    public void setListLocation(List<Location> listLocation) {
        this.listLocation = listLocation;
    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    public List<Livre> getResultLivre() {
        return ResultLivre;
    }

    public void setResultLivre(List<Livre> resultLivre) {
        ResultLivre = resultLivre;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public List<Livre> getListLivre() {
        return ListLivre;
    }

    public void setListLivre(List<Livre> listLivre) {
        ListLivre = listLivre;
    }

    public String doRecherche() throws NotFoundException, NotFoundException_Exception {

    String vResult = ActionSupport.INPUT;

        BiblioService_Service pBiblio = new BiblioService_Service();

        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

        if (this.livre != null) {

            this.ResultLivre = pBiblioService.doResultLivre(livre.getGenre());
            vResult = ActionSupport.SUCCESS;
        }
        if (vResult.equals(ActionSupport.INPUT)) {
            this.ListLivre = pBiblioService.doListLivre();
        }
        return vResult;
   }



    public String doBack() {

        String vResult = ActionSupport.INPUT;

        BiblioService_Service pBiblio = new BiblioService_Service();
        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

        //user_id
        Utilisateur vUser = (Utilisateur) this.session.get("utilisateur");

        if (vUser != null){
        listLocation = pBiblioService.getListLocation(vUser.getId());
        } else {
            this.addActionError("Identifiant ou mot de passe invalide !");
            vResult = ActionSupport.ERROR;
        }

        if (this.livre != null) {

            Livre vLivre = pBiblioService.getLivreTitre(livre.getTitre());
            String chaine = livre.getTitre();
            //user_position
            try {
                booking = pBiblioService.userPosition(vLivre.getId());
            } catch (NotFoundException_Exception e) {
                e.printStackTrace();
            }
            //mail
            if(booking!=null) {
                user = pBiblioService.getUtilisateur(booking.getUserId());
                // Calcul date
                Calendar toDay = Calendar.getInstance();
                Date date = toDay.getTime();
                SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
                String dateNotif = formatter.format(date);
                //Update DateNotif
                pBiblioService.addNotif(dateNotif, booking.getId());
            }

            for (Location loc : listLocation){

                if (vLivre.getId() == loc.getLivreId()) {
                    pBiblioService.delLoc(loc);
                    vResult = ActionSupport.SUCCESS;
                }
            }
        }
        if (vResult.equals(ActionSupport.INPUT)) {

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

                    listEmprunt.add(vEmprunt);
                }
        }
        return vResult;

    }
}
