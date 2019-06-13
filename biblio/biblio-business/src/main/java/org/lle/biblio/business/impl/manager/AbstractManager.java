package org.lle.biblio.business.impl.manager;

import org.lle.biblio.consumer.contract.DaoFactory;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public abstract class AbstractManager {

    @Inject
    @Named("txManagerBiblio")
    private PlatformTransactionManager platformTransactionManager;
    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }


    @Inject
    private DaoFactory daoFactory;
    protected DaoFactory getDaoFactory() {
        return daoFactory;
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
