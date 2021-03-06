package org.lle.biblio.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.lle.biblio.business.contract.ManagerFactory;
import org.lle.biblio.model.bean.emprunt.Emprunt;
//import org.lle.biblio.model.bean.livre.Booking;
import org.lle.biblio.webapp.generated.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class LoginAction extends ActionSupport implements ServletRequestAware, SessionAware {

    // ----- Eléments Struts
    @Inject
    private ManagerFactory managerFactory;

    private Map<String, Object> session;
    private Utilisateur utilisateur;
    private String pseudo;
    private Location location;
    private Livre livre;
    private Auteur auteur;
    private String prolongation;
    private String login;
    private String password;
    private List<Location> listLocation;
    private List<Emprunt> listEmprunt;
    private List<Booking> listBooking;
    private List<Emprunt> listResa;
    private Integer Resaid;
    private int vPosition;
    private String dateRetour;
    private Location vLocation;
    private int id;
    private String activation;
    private boolean recall;

    public boolean isRecall() {
        return recall;
    }

    public void setRecall(boolean recall) {
        this.recall = recall;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getvLocation() {
        return vLocation;
    }

    public void setvLocation(Location vLocation) {
        this.vLocation = vLocation;
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

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    private HttpServletRequest servletRequest;

    @Override
    public void setServletRequest(HttpServletRequest pRequest) {
        this.servletRequest = pRequest;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String pLogin)  {
        login = pLogin;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    // ==================== Méthodes ====================
        /**
         * Action permettant la connexion d'un utilisateur
         * @return input / success
         */
        public String doLogin() {
            String vResult = ActionSupport.INPUT;

            if (!StringUtils.isAllEmpty(login, password)) {

                BiblioService_Service pBiblio = new BiblioService_Service();

                BiblioService pBiblioService = pBiblio.getBiblioServicePort();

                utilisateur = pBiblioService.doLogin(login, password);

                recall = pBiblioService.getRecall(utilisateur.getId());

                if (recall){
                    activation = "true";
                }else{
                    activation = "false";
                }

                if (utilisateur != null) {
                        // Ajout de l'utilisateur en session
                        this.session.put("utilisateur", utilisateur);

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

                        //vLocation=pBiblioService.getLivrelocation(book.getLivreId());
/*
                        if(vLocation != null) {
                            dateRetour = vLocation.getExpiredate();
                        }else{
                            dateRetour = "disponible";
                        }
*/
                        livre = pBiblioService.getLivre(book.getLivreId());
                        auteur = pBiblioService.getAuteur(livre.getAuteurId());
                        dateRetour= book.getBookingdate();
                        vEmprunt.setTitre(livre.getTitre());
                        vEmprunt.setDescription(livre.getDescription());
                        vEmprunt.setGenre(livre.getGenre());
                        vEmprunt.setNom(auteur.getNom());
                        vEmprunt.setId(livre.getId());


                        listResa.add(vEmprunt);

                    }

                        vResult = ActionSupport.SUCCESS;
                    } else {


                        this.addActionError("Identifiant ou mot de passe invalide !");
                        vResult = ActionSupport.ERROR;
                    }
                }
            return vResult;

        }
        /**
         * Action de déconnexion d'un utilisateur
         * @return success
         */
        public String doLogout() {

            // Invalidation de la session
            this.servletRequest.getSession().invalidate();
            return ActionSupport.SUCCESS;
        }

        public String desactivation(){

            String vResult = ActionSupport.INPUT;

            if(id >0){

                BiblioService_Service pBiblio = new BiblioService_Service();

                BiblioService pBiblioService = pBiblio.getBiblioServicePort();

                pBiblioService.delRecall(id);

                 vResult = ActionSupport.SUCCESS;

            }

            return  vResult;
        }

    public String activation(){

        String vResult = ActionSupport.INPUT;

        if(id >0){

            BiblioService_Service pBiblio = new BiblioService_Service();

            BiblioService pBiblioService = pBiblio.getBiblioServicePort();

            pBiblioService.addRecall(id);

            vResult = ActionSupport.SUCCESS;

        }

        return  vResult;
    }
    }
