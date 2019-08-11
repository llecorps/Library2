package org.lle.biblio.batch.traitement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lle.biblio.batch.generated.BiblioService;
import org.lle.biblio.batch.generated.BiblioService_Service;
import org.lle.biblio.model.bean.livre.Booking;
import org.lle.biblio.model.exception.TechnicalException;

import javax.mail.NoSuchProviderException;
import java.util.List;

/**
 * Created by TheAdmin on 23.07.2019.
 */
public class CheckNotification extends AbstractTraitement {

    /** Logger pour la classe  ajout ticket strus2*/
    private static final Log LOGGER = LogFactory.getLog(CheckNotification.class);

    private List<Booking> listBooking;

    public List<Booking> getListBooking() {
        return listBooking;
    }

    public void setListBooking(List<Booking> listBooking) {
        this.listBooking = listBooking;
    }

    public void run() throws TechnicalException, NoSuchProviderException {

        BiblioService_Service pBiblio = new BiblioService_Service();
        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

       // listBooking = pBiblioService.

    }

    }// Class End
