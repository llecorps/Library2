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
 * Created by TheAdmin on 25.08.2019.
 */
public class CheckRecall extends AbstractTraitement {

    /** Logger pour la classe  ajout ticket strus2*/
    private static final Log LOGGER = LogFactory.getLog(CheckNotification.class);
    
    private List<Utilisateur> listUser;
    private List<Location> listLocation;

    public List<Location> getListLocation() {
        return listLocation;
    }

    public void setListLocation(List<Location> listLocation) {
        this.listLocation = listLocation;
    }

    public List<Utilisateur> getListUser() {
        return listUser;
    }

    public void setListUser(List<Utilisateur> listUser) {
        this.listUser = listUser;
    }

    public void run() throws TechnicalException, NoSuchProviderException {

        BiblioService_Service pBiblio = new BiblioService_Service();
        BiblioService pBiblioService = pBiblio.getBiblioServicePort();
        
        listUser = pBiblioService.listRecall();

        for (Utilisateur user : listUser){

            if (user.isRecall()){

                Calendar nowCal = Calendar.getInstance();
                nowCal.add(Calendar.DATE, 5);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date nowDate = nowCal.getTime();
                String ajd = formatter.format(nowDate);
                Date dateRecall = null;
                try {
                    dateRecall = new SimpleDateFormat("yyyy-MM-dd").parse(ajd);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                listLocation = pBiblioService.getListLocation(user.getId());

                for ( Location loc : listLocation){
                    //if (loc.getExpiredate().equals(dateRecall)){
                    if (loc.getExpiredate().equals(ajd)) {

                        Livre vLivre = pBiblioService.getLivre(loc.getLivreId());
                        String mail = user.getEmail();

                        String to = mail;
                        String subject = "Emprunt";
                        String msg = "Votre emprunt :\n" + vLivre.getTitre() + "\n se termine dans 5 jours!";
                        final String from = "XXX@gmail.com";
                        final String password = "";


                        Properties props = new Properties();
                        props.setProperty("mail.transport.protocol", "smtp");
                        props.setProperty("mail.host", "smtp.gmail.com");
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.port", "465");
                        props.put("mail.debug", "true");
                        props.put("mail.smtp.socketFactory.port", "465");
                        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                        props.put("mail.smtp.socketFactory.fallback", "false");
                        Session session = Session.getDefaultInstance(props,
                                new javax.mail.Authenticator() {
                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication(from, password);
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
                            // transport.connect();
                            // Transport.send(message);
                            // transport.close();
                            System.out.println("=====>mail envoyé !");

                        } catch (MessagingException e) {
                            e.printStackTrace();
                        }

                    }else{
                        System.out.println("Pas de rappel à faire !");

                    }//end if date

                }// end for location
               

            }// end if

        }// end for

    }
}
