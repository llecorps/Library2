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
 * Created by TheAdmin on 23.07.2019.
 */
public class CheckNotification extends AbstractTraitement {

    /** Logger pour la classe  ajout ticket strus2*/
    private static final Log LOGGER = LogFactory.getLog(CheckNotification.class);

    private List<Booking> listBooking;
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

    public List<Booking> getListBooking() {
        return listBooking;
    }

    public void setListBooking(List<Booking> listBooking) {
        this.listBooking = listBooking;
    }

    public void run() throws TechnicalException, NoSuchProviderException {

        BiblioService_Service pBiblio = new BiblioService_Service();
        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

        listBooking = pBiblioService.listBooking();

        for (Booking book : listBooking) {

            Calendar toDay = Calendar.getInstance();
            Date date = toDay.getTime();

            Date dateJour = new java.util.Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateChaine = formatter.format(dateJour);
            Date dateFormat = null;
            try {
                dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(dateChaine);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Date dateBooking = null;

            if (book.getNotification() != null) {

                try {
                    dateBooking = new SimpleDateFormat("yyyy-MM-dd").parse(book.getNotification());
                    System.out.println("Date de réservation est:" + dateBooking);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (dateBooking.equals(dateFormat)) {
                    Utilisateur vUtilisateur = pBiblioService.getUtilisateur(book.getUserId());
                    Livre vLivre = pBiblioService.getLivre(book.getLivreId());
                    String mail = vUtilisateur.getEmail();


                    //Envoi Mail

                    String to = mail;
                    String subject = "Réservation";
                    String msg = "Votre ouvrage est disponible:\n" + vLivre.getTitre() + "\n Cordialement";
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

                } else {

                    Calendar nowCal = Calendar.getInstance();
                    nowCal.add(Calendar.DATE, -2);
                    Date nowDate = nowCal.getTime();
                    String ajd = formatter.format(nowDate);
                    Date dateCancel = null;
                    try {
                        dateCancel = new SimpleDateFormat("yyyy-MM-dd").parse(ajd);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    if (dateBooking.equals(dateCancel)) {

                        pBiblioService.delBooked(book.getId());
                        System.out.println("===>Réservation annulée!");
                        Livre vLivre = pBiblioService.getLivre(book.getLivreId());


                        try {
                            booking = pBiblioService.userPosition(vLivre.getId());
                        } catch (NotFoundException_Exception e) {
                            e.printStackTrace();
                        }
                        if (booking != null) {
                            user = pBiblioService.getUtilisateur(booking.getUserId());
                            // Calcul date
                            SimpleDateFormat toFormat = new SimpleDateFormat("YYYY-MM-dd");
                            String dateNotif = toFormat.format(date);
                            //Update DateNotif
                            pBiblioService.addNotif(dateNotif, booking.getId());
                            System.out.println("===>nouvelle notification envoyée!");
                        }else {
                            System.out.println("===>plus de réservation pour ce livre!");
                        }
                    }

                }

            }else{
                System.out.println("===> pas de notification!");
            }
        }


    }

    }// Class End
