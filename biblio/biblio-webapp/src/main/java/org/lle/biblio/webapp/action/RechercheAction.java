package org.lle.biblio.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.lle.biblio.model.exception.NotFoundException;
import org.lle.biblio.webapp.generated.BiblioService;
import org.lle.biblio.webapp.generated.BiblioService_Service;
import org.lle.biblio.webapp.generated.Livre;
import org.lle.biblio.webapp.generated.NotFoundException_Exception;

import java.util.List;

/**
 * Created by TheAdmin on 26.01.2019.
 */
public class RechercheAction extends ActionSupport {


    private List<Livre> ListLivre;
    private List<Livre> ResultLivre;
    private Livre livre;

    public List<Livre> getResultLivre() {
        return ResultLivre;
    }

    public void setResultLivre(List<Livre> resultLivre) {
        ResultLivre = resultLivre;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public List<Livre> getListLivre() {
        return ListLivre;
    }

    public void setListLivre(List<Livre> listLivre) {
        ListLivre = listLivre;
    }

    public String doRecherche() throws NotFoundException, NotFoundException_Exception {

    String vResult = ActionSupport.INPUT;

        BiblioService_Service pBiblio = new BiblioService_Service();

        BiblioService pBiblioService = pBiblio.getBiblioServicePort();

        if (this.livre != null) {

            this.ResultLivre = pBiblioService.doResultLivre(livre.getGenre());

            vResult = ActionSupport.SUCCESS;

        }


        if (vResult.equals(ActionSupport.INPUT)) {
            this.ListLivre = pBiblioService.doListLivre();
        }
        return vResult;
   }
}
