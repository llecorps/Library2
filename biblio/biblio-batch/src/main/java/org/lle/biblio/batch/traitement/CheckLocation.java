package org.lle.biblio.batch.traitement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lle.biblio.batch.generated.*;
import org.lle.biblio.model.exception.TechnicalException;

import javax.mail.*;
import javax.mail.internet.AddressException;
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

    /** Logger pour la classe */
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
                final String from ="laurent.lecorps@gmail.com";
                final  String password ="Blueparrot01!";


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
                } catch (AddressException e) {
                    e.printStackTrace();
                }

                MimeMessage message = new MimeMessage(session);
                try {
                    message.setSender(addressFrom);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                try {
                    message.setSubject(subject);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                try {
                    message.setContent(msg, "text/plain");
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                try {
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                } catch (MessagingException e) {
                    e.printStackTrace();
                }

                try {
                    transport.connect();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                try {
                    Transport.send(message);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                try {
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
