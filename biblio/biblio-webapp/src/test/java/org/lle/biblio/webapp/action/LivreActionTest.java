package org.lle.biblio.webapp.action;

import org.junit.Before;
import org.junit.Test;
import org.lle.biblio.webapp.generated.BiblioService;
import org.lle.biblio.webapp.generated.BiblioService_Service;
import org.lle.biblio.webapp.generated.Booking;
import org.lle.biblio.webapp.generated.Livre;

import java.util.List;

/**
 * Created by TheAdmin on 11.07.2019.
 */
public class LivreActionTest {


    private LivreAction manager = new LivreAction();

    private Integer id;

    private Livre livre;

    private int nbreResa;
    private String expireDate;
    private List<Booking> listResa;

    public List<Booking> getListResa() {
        return listResa;
    }

    public void setListResa(List<Booking> listResa) {
        this.listResa = listResa;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public int getNbreResa() {
        return nbreResa;
    }

    public void setNbreResa(int nbreResa) {
        this.nbreResa = nbreResa;
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

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void doDispo() throws Exception {



        BiblioService_Service pBiblio = new BiblioService_Service();
        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

            livre = pBiblioService.getLivre(id);
            nbreResa = 0;

            //test exemplaire
            int vExmplaire = pBiblioService.getExemplaire(livre.getId());
            if (vExmplaire == livre.getExemplaire()) {

                expireDate = pBiblioService.getExpiredate(id);

                listResa = pBiblioService.getListReservation(1);

                for (Booking resa : listResa) {
                    if (id == resa.getLivreId()) {
                        nbreResa ++;
                    }
                }
        }

    }


}