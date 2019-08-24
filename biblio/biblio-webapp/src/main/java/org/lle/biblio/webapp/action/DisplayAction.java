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
    private Integer Resaid;
    private Livre livre;
    private Auteur auteur;
    private String login;
    private List<Location> listLocation;
    private List<Emprunt> listEmprunt;
    private Utilisateur utilisateur;
    private String prolongation;
    private List<Booking> listBooking;
    private List<Emprunt> listResa;
    private int vPosition;
    private String dateRetour;
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public int getvPosition() {
        return vPosition;
    }

    public void setvPosition(int vPosition) {
        this.vPosition = vPosition;
    }


    public Integer getResaid() {
        return Resaid;
    }

    public void setResaid(Integer resaid) {
        Resaid = resaid;
    }

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

    public List<Booking> getListBooking() {
        return listBooking;
    }

    public void setListBooking(List<Booking> listBooking) {
        this.listBooking = listBooking;
    }

    public List<Emprunt> getListResa() {
        return listResa;
    }

    public void setListResa(List<Emprunt> listResa) {
        this.listResa = listResa;
    }

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
            //listbooked

            listBooking = pBiblioService.getListReservation(utilisateur.getId());
            listResa = new ArrayList<Emprunt>();

            for (Booking book : listBooking){

                Emprunt vEmprunt = new Emprunt();

                Resaid = book.getId();
                vPosition=book.getPosition();
                /*
                location=pBiblioService.getLivrelocation(book.getLivreId());

                if(location != null) {
                    dateRetour = location.getExpiredate();
                }else{
                    dateRetour = "disponible";
                }*/
                dateRetour= book.getBookingdate();
                livre = pBiblioService.getLivre(book.getLivreId());
                auteur = pBiblioService.getAuteur(livre.getAuteurId());

                vEmprunt.setTitre(livre.getTitre());
                vEmprunt.setDescription(livre.getDescription());
                vEmprunt.setGenre(livre.getGenre());
                vEmprunt.setNom(auteur.getNom());
                vEmprunt.setId(livre.getId());


                listResa.add(vEmprunt);

            }
            vResult = ActionSupport.SUCCESS;

        }else{
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }
}
