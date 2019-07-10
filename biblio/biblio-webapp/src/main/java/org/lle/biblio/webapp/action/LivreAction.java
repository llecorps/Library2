package org.lle.biblio.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.lle.biblio.webapp.generated.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by TheAdmin on 06.02.2019.
 */
public class LivreAction extends ActionSupport implements SessionAware {

    private Integer id;
    private Integer Resaid;
    private Livre livre;
    private Auteur auteur;
    private String login;
    private Location location;
    private List<Location> listLocation;
    private boolean autho;
    public List<Booking> listResa;
    private String expireDate;
    private int nbreResa;

    public int getNbreResa() {
        return nbreResa;
    }

    public void setNbreResa(int nbreResa) {
        this.nbreResa = nbreResa;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public List<Booking> getListResa() {
        return listResa;
    }

    public void setListResa(List<Booking> listResa) {
        this.listResa = listResa;
    }

    public boolean isAutho() {
        return autho;
    }

    public void setAutho(boolean autho) {
        this.autho = autho;
    }

    public List<Location> getListLocation() {
        return listLocation;
    }

    public void setListLocation(List<Location> listLocation) {
        this.listLocation = listLocation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public Integer getResaid() {
        return Resaid;
    }

    public void setResaid(Integer resaid) {
        Resaid = resaid;
    }


    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }


    public String doDetail() {

        BiblioService_Service pBiblio = new BiblioService_Service();

        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

        if (id == null) {
            this.addActionError(getText("error.livre.missing.id"));
        } else {

            livre = pBiblioService.getLivre(id);
            auteur = pBiblioService.getAuteur(livre.getAuteurId());

        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doRent() {

        String vResult = ActionSupport.INPUT;

        BiblioService_Service pBiblio = new BiblioService_Service();
        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

        //user_id
        Utilisateur vUser = (Utilisateur) this.session.get("utilisateur");
/*
        autho=true;

        listResa = pBiblioService.getListReservation(vUser.getId());

        for (Booking resa : listResa){
            if (id == resa.getLivreId()){

                autho=false;
                vResult = ActionSupport.ERROR;
            }
        }*/

        if (id != null) {
       // if (autho){

            livre = pBiblioService.getLivre(id);

            //test exemplaire
            int vExmplaire = pBiblioService.getExemplaire(livre.getId());
            if (vExmplaire == livre.getExemplaire()) {

                //this.addActionError("ouvrage non disponible !");
                vResult = ActionSupport.NONE;

            } else {

                Calendar expireDate = Calendar.getInstance();
                expireDate.add(Calendar.DATE, 28);
                Date date = expireDate.getTime();
                SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
                String dateRetour = formatter.format(date);

                //Utilisateur vUser = (Utilisateur) this.session.get("utilisateur");

                Location pLocation = new Location();
                pLocation.setExpiredate(dateRetour);
                pLocation.setLivreId(livre.getId());
                pLocation.setUtilisateurId(vUser.getId());
                pLocation.setProlongation(true);

                pBiblioService.addLocation(pLocation);

                vResult = ActionSupport.SUCCESS;
            }
        }

        return vResult;
    }

    public String doLoc() {

        String vResult = ActionSupport.INPUT;

        BiblioService_Service pBiblio = new BiblioService_Service();
        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

        //user_id
        Utilisateur vUser = (Utilisateur) this.session.get("utilisateur");


        if (id != null) {

            listResa = pBiblioService.getListReservation(vUser.getId());

            for (Booking resa : listResa){
                if (id == resa.getLivreId()){

                    pBiblioService.delBooked(resa.getId());
                }
            }

            livre = pBiblioService.getLivre(id);

            //test exemplaire
            int vExmplaire = pBiblioService.getExemplaire(livre.getId());
            if (vExmplaire == livre.getExemplaire()) {

                //this.addActionError("ouvrage non disponible !");
                vResult = ActionSupport.ERROR;

            } else {

                Calendar expireDate = Calendar.getInstance();
                expireDate.add(Calendar.DATE, 28);
                Date date = expireDate.getTime();
                SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
                String dateRetour = formatter.format(date);

                //Utilisateur vUser = (Utilisateur) this.session.get("utilisateur");

                Location pLocation = new Location();
                pLocation.setExpiredate(dateRetour);
                pLocation.setLivreId(livre.getId());
                pLocation.setUtilisateurId(vUser.getId());
                pLocation.setProlongation(true);

                pBiblioService.addLocation(pLocation);

                vResult = ActionSupport.SUCCESS;
            }
        }

        return vResult;
    }

    public String doBook() {


        String vResult = ActionSupport.INPUT;

        BiblioService_Service pBiblio = new BiblioService_Service();
        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

        //user_id
        Utilisateur vUser = (Utilisateur) this.session.get("utilisateur");

       autho=true;

        //livre_id
        if (id != null) {

            listLocation = pBiblioService.getListLocation(vUser.getId());

            for (Location loc : listLocation){
                if (id == loc.getLivreId()){

                    autho=false;
                     vResult = ActionSupport.ERROR;
                }
            }

            //nbre de résas

            int nbreExemplaire = pBiblioService.getExemplaire(id);
            int nbreMax = 2*nbreExemplaire;
            int nbreResa = pBiblioService.getNbreLocation(id);
            if (nbreResa >= nbreMax ){
                autho=false;
                vResult = ActionSupport.ERROR;
            }

            listResa = pBiblioService.getListReservation(vUser.getId());

            for (Booking resa : listResa){
                if (id == resa.getLivreId()){

                    autho=false;
                    vResult = ActionSupport.ERROR;
                }
            }



            if(autho) {

                //bookingate
                Calendar now = Calendar.getInstance();
                Date date = now.getTime();
                SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
                String bookingdate = formatter.format(date);

                //position
                int vLastPos = pBiblioService.getPosition(id);
                int vPosition = vLastPos+1;

                //Bean Booking

                Booking pBooking = new Booking();
                pBooking.setBookingdate(bookingdate);
                pBooking.setLivreId(id);
                pBooking.setUserId(vUser.getId());
                pBooking.setPosition(vPosition);

                //Service
                pBiblioService.addBooked(pBooking);

                vResult = ActionSupport.SUCCESS;


            }
        }

         return vResult;
        //return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doProlo() {

        BiblioService_Service pBiblio = new BiblioService_Service();

        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

        if (id != null) {

            System.out.println("Id du livre est:" + id);

            location = pBiblioService.getLivrelocation(id);

            if (location.isProlongation() == true) {

                Calendar expireDate = Calendar.getInstance();
                expireDate.add(Calendar.DATE, 28);
                Date date = expireDate.getTime();
                SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
                String dateRetour = formatter.format(date);

                pBiblioService.addProlo(dateRetour, location.getId());

            } else {

                System.out.println("Prolongation non possible!");
            }

        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;

    }

    public String doCancel() {

        BiblioService_Service pBiblio = new BiblioService_Service();

        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

        if (Resaid != null) {

            pBiblioService.delBooked(Resaid);
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doDispo() {

        String vResult = ActionSupport.INPUT;

        BiblioService_Service pBiblio = new BiblioService_Service();
        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

        if (id != null) {

            livre = pBiblioService.getLivre(id);
            //user_id
            Utilisateur vUser = (Utilisateur) this.session.get("utilisateur");

            nbreResa = 0;

            //test exemplaire
            int vExmplaire = pBiblioService.getExemplaire(livre.getId());
            if (vExmplaire == livre.getExemplaire()) {

                expireDate = pBiblioService.getExpiredate(id);

                listResa = pBiblioService.getListReservation(vUser.getId());

                for (Booking resa : listResa) {
                    if (id == resa.getLivreId()) {
                        nbreResa ++;
                    }
                }

                //this.addActionError("ouvrage non disponible !");
                vResult = ActionSupport.NONE;

            } else {



                vResult = ActionSupport.SUCCESS;
            }
        }

        return vResult;
    }
}


