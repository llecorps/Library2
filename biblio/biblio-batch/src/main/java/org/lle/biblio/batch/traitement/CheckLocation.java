package org.lle.biblio.batch.traitement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lle.biblio.batch.generated.*;
import org.lle.biblio.model.exception.TechnicalException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by TheAdmin on 21.02.2019.
 */
public class CheckLocation extends AbstractTraitement{

    /** Logger pour la classe  ajout ticket strus2*/
    private static final Log LOGGER = LogFactory.getLog(CheckLocation.class);

    private List<Location> listLocation;

    public List<Location> getListLocation() {
        return listLocation;
    }

    public void setListLocation(List<Location> listLocation) {
        this.listLocation = listLocation;
    }

    public void run() throws TechnicalException, NoSuchProviderException {

        BiblioService_Service pBiblio = new BiblioService_Service();
        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

        listLocation = pBiblioService.listLocation();

        for (Location loc : listLocation){

            Calendar toDay = Calendar.getInstance();
            Date date = toDay.getTime();

            Date dateLocation = null;
            try {
                dateLocation = new SimpleDateFormat("yyyy-MM-dd").parse(loc.getExpiredate());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (dateLocation.before(date)){
                System.out.println("Date Location:"+dateLocation+" est expirée par rapport à:"+date);
                //récupération mail

                Utilisateur vUtilisateur = pBiblioService.getUtilisateur(loc.getUtilisateurId());
                Livre vLivre = pBiblioService.getLivre(loc.getLivreId());

                String mail = vUtilisateur.getEmail();

                //Envoi Mail

                String to = mail;
                String subject = "Relance Emprunt";
                String msg ="Veuillez retourner cet ouvrage:\n"+vLivre.getTitre()+"\n Cordialement";
                final String from ="XXX@gmail.com";
                final  String password ="";


                Properties props = new Properties();
                props.setProperty("mail.transport.protocol", "smtp");
                props.setProperty("mail.host", "smtp.gmail.com");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                props.put("mail.debug", "true");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.socketFactory.fallback", "false");
                Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(from,password);
                            }
                        });

                //session.setDebug(true);
                Transport transport = session.getTransport();
                InternetAddress addressFrom = null;
                try {
                    addressFrom = new InternetAddress(from);
                    MimeMessage message = new MimeMessage(session);
                    message.setSender(addressFrom);
                    message.setSubject(subject);
                    message.setContent(msg, "text/plain");
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    transport.connect();
                    Transport.send(message);
                    transport.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }

            }else {
                System.out.println("Date Location est valide:" + dateLocation);

            }

        }

    }




}
