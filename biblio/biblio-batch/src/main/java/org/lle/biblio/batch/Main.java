package org.lle.biblio.batch;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lle.biblio.batch.traitement.CheckNotification;
import org.lle.biblio.model.exception.TechnicalException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Classe Principale de lancement des Batches.
 *
 * @author lgu
 */
public class Main {

    /** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(Main.class);


    /**
     * The entry point of application.
     *
     * @param pArgs the input arguments
     * @throws TechnicalException sur erreur technique
     */
    public static void main(String[] pArgs) throws TechnicalException {
        ApplicationContext vApplicationContext
            = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

        try {
            if (pArgs.length < 1) {
                throw new TechnicalException("Veuillez préciser le traitement à effectuer !");
            }

            String vTraitementId = pArgs[0];

            //if ("CheckLocation".equals(vTraitementId)) {
            if ("CheckNotification".equals(vTraitementId)) {
                LOGGER.info("Execution du traitement Batch");

                //CheckLocation vTraitement  = vApplicationContext.getBean("CheckLocation", CheckLocation.class);
                CheckNotification vTraitement  = vApplicationContext.getBean("CheckNotification", CheckNotification.class);
                vTraitement.run();
            } else {
                throw new TechnicalException("Traitement inconnu : " + vTraitementId);
            }
        } catch (Throwable vThrowable) {
            LOGGER.error("Erreur générale", vThrowable);
            System.exit(1);
        }
    }
}
