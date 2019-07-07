package org.lle.biblio.service;

import org.lle.biblio.model.bean.auteur.Auteur;
import org.lle.biblio.model.bean.livre.Booking;
import org.lle.biblio.model.bean.livre.Livre;
import org.lle.biblio.model.bean.location.Location;
import org.lle.biblio.model.bean.utilisateur.Utilisateur;
import org.lle.biblio.model.exception.NotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheAdmin on 24.01.2019.
 */

@WebService(serviceName = "BiblioService")
public class BiblioService extends AbstractService{

    private ApplicationContext vApplicationContext;

    public BiblioService() {

        vApplicationContext = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

    }

    @WebMethod
    public Utilisateur DoLogin(String login, String password){

        //ApplicationContext vApplicationContext
          //     = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

        LoginServiceImpl vLoginService = vApplicationContext.getBean("LoginServiceImpl", LoginServiceImpl.class);



       Utilisateur vUtilisateur = vLoginService.doLogin(login, password);

        return vUtilisateur;
    }

    @WebMethod
    public Location getLocation(int id){


        LocationServiceImpl vLocationService = vApplicationContext.getBean("LocationServiceImpl", LocationServiceImpl.class);

        Location vLocation = vLocationService.getLocation(id);

        return vLocation;

    }

    @WebMethod
    public Location getLivrelocation(int id){


        LocationServiceImpl vLocationService = vApplicationContext.getBean("LocationServiceImpl", LocationServiceImpl.class);

        Location vLocation = vLocationService.getLivrelocation(id);

        return vLocation;

    }

    @WebMethod
    public List<Location> getListLocation( int id){


        LocationServiceImpl vLocationService = vApplicationContext.getBean("LocationServiceImpl", LocationServiceImpl.class);

        List<Location> vListLocation = vLocationService.getListLocation(id);

        return  vListLocation;
    }

    @WebMethod
    public int getNbreLocation( int id){


        LocationServiceImpl vLocationService = vApplicationContext.getBean("LocationServiceImpl", LocationServiceImpl.class);

        int vNbreLocation = vLocationService.getNbreLocation(id);

        return  vNbreLocation;
    }

    @WebMethod
    public int getPosition( int id){


        LocationServiceImpl vLocationService = vApplicationContext.getBean("LocationServiceImpl", LocationServiceImpl.class);

        int vPosition = vLocationService.getPosition(id);

        return  vPosition;
    }

    @WebMethod
    public List<Booking> getListReservation(int id){


        LocationServiceImpl vLocationService = vApplicationContext.getBean("LocationServiceImpl", LocationServiceImpl.class);

        List<Booking> vListReservation = vLocationService.getListReservation(id);

        return  vListReservation;
    }

    @WebMethod
    public  List<Location> listLocation( ){


        LocationServiceImpl vLocationService = vApplicationContext.getBean("LocationServiceImpl", LocationServiceImpl.class);

        List<Location> vListLocation = vLocationService.listLocation();

       return vListLocation;
    }

    @WebMethod
    public void addProlo( String expiration,int id){


        LocationServiceImpl vLocationService = vApplicationContext.getBean("LocationServiceImpl", LocationServiceImpl.class);

        vLocationService.addProlo(expiration,id);

    }


    @WebMethod
    public void addLocation(Location pLocation){


        LocationServiceImpl vLocationService = vApplicationContext.getBean("LocationServiceImpl", LocationServiceImpl.class);

        vLocationService.addEmprunt(pLocation);

    }

    @WebMethod
    public void addBooked(Booking pBooking){


        LocationServiceImpl vLocationService = vApplicationContext.getBean("LocationServiceImpl", LocationServiceImpl.class);

        vLocationService.addBooked(pBooking);

    }

    @WebMethod
    public void delBooked(int id){


        LocationServiceImpl vLocationService = vApplicationContext.getBean("LocationServiceImpl", LocationServiceImpl.class);

        vLocationService.delBooked(id);

    }

    @WebMethod
    public int getExemplaire(int id){

        LocationServiceImpl vLocationService = vApplicationContext.getBean("LocationServiceImpl", LocationServiceImpl.class);

        int vExemplaire = vLocationService.getExemplaire(id);

        return vExemplaire;

    }

    @WebMethod
    public Livre getLivre(int id){


    LivreServiceImpl vLivreService = vApplicationContext.getBean("LivreServiceImpl", LivreServiceImpl.class);

    Livre vLivre = vLivreService.getLivre(id);

    return vLivre;

    }

    @WebMethod
    public Auteur getAuteur(int id){


        AuteurServiceImpl vAuteurService = vApplicationContext.getBean("AuteurServiceImpl", AuteurServiceImpl.class);

        Auteur vAuteur = vAuteurService.getAuteur(id);

        return vAuteur;

    }

    @WebMethod
    public Utilisateur getUtilisateur(int id){


        UtilisateurServiceImpl vUtilisateurService = vApplicationContext.getBean("UtilisateurServiceImpl", UtilisateurServiceImpl.class);

        Utilisateur vUtilisateur = vUtilisateurService.getUtilisateur(id);

        return vUtilisateur;

    }

    @WebMethod
    public List<Livre> DoListLivre() throws NotFoundException {

        LivreServiceImpl vLivreService = vApplicationContext.getBean("LivreServiceImpl", LivreServiceImpl.class);

        List<Livre> vListLivre =  new ArrayList<>();
        vListLivre = vLivreService.getListLivre();

        return vListLivre;

    }
    @WebMethod
    public List<Livre> DoResultLivre(String chaine) throws NotFoundException {


        LivreServiceImpl vLivreService = vApplicationContext.getBean("LivreServiceImpl", LivreServiceImpl.class);

        List<Livre> vListLivre =  new ArrayList<>();
        vListLivre = vLivreService.getResultLivre(chaine);

        return vListLivre;

    }
}
