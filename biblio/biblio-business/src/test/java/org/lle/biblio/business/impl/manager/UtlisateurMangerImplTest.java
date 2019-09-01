package org.lle.biblio.business.impl.manager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lle.biblio.model.bean.utilisateur.Utilisateur;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by TheAdmin on 01.09.2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class UtlisateurMangerImplTest {

    //private UtilisateurManagerImpl manager;
    @Mock
    private Utilisateur pUtilisateur;

    @Before
    public void setUp() throws Exception {

        ApplicationContext vApplicationContext
                = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

        //manager = vApplicationContext.getBean("UtilisateurManagerImpl", UtilisateurManagerImpl.class);

    }

    @Test
    public void getUtilisateur() {

        Mockito.when(pUtilisateur.getLogin()).thenReturn("user1");
        Mockito.when(pUtilisateur.getLogin()).thenReturn("passwd");

        Assert.assertNotNull(pUtilisateur);

    }

}
