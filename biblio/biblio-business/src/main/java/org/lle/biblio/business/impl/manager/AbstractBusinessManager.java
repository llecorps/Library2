package org.lle.biblio.business.impl.manager;

import org.lle.biblio.business.contract.BusinessProxy;
import org.lle.biblio.consumer.contract.dao.DaoProxy;
import org.lle.biblio.business.impl.TransactionManager;

import javax.validation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


/**
 * <p>Classe mère des Managers</p>
 */
public abstract class AbstractBusinessManager {

    /** Le Proxy d'accès à la couche Business */
    private static BusinessProxy businessProxy;
    /** Le Proxy d'accès à la couche Consumer-DAO */
    private static DaoProxy daoProxy;
    /** Le gestionnaire de Transaction */
    private static TransactionManager transactionManager;


    // ==================== Constructeurs ====================

    /**
     * Méthode de configuration de la classe
     *
     * @param pBusinessProxy      -
     * @param pDaoProxy           -
     * @param pTransactionManager -
     */
    public static void configure(BusinessProxy pBusinessProxy,
                                 DaoProxy pDaoProxy,
                                 TransactionManager pTransactionManager) {
        businessProxy = pBusinessProxy;
        daoProxy = pDaoProxy;
        transactionManager = pTransactionManager;
    }


    // ==================== Getters/Setters ====================

    /**
     * Renvoie le Proxy d'accès à la couche Business
     *
     * @return {@link BusinessProxy}
     */
    protected BusinessProxy getBusinessProxy() {
        return businessProxy;
    }


    /**
     * Renvoie le Proxy d'accès à la couche Consumer-DAO
     *
     * @return {@link DaoProxy}
     */
    protected DaoProxy getDaoProxy() {
        return daoProxy;
    }


    /**
     * Renvoie le gestionnaire de Transaction
     *
     * @return TransactionManager
     */
    protected TransactionManager getTransactionManager() {
        return transactionManager;
    }


    /**
     * Renvoie un {@link Validator} de contraintes
     *
     * @return Validator
     */
    protected Validator getConstraintValidator() {
        Configuration<?> vConfiguration = Validation.byDefaultProvider().configure();
        ValidatorFactory vFactory = vConfiguration.buildValidatorFactory();
        Validator vValidator = vFactory.getValidator();
        return vValidator;
    }
}
