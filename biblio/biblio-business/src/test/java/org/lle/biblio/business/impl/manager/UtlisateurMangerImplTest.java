package org.lle.biblio.business.impl.manager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lle.biblio.model.bean.utilisateur.Utilisateur;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheAdmin on 01.09.2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class UtlisateurMangerImplTest {

    //private UtilisateurManagerImpl manager;
    @Mock
    private Utilisateur pUtilisateur;
    @Spy
    List<Utilisateur> listRecall = new ArrayList<Utilisateur>();
    private Utilisateur user = new Utilisateur();;

    @Before
    public void setUp() throws Exception {

        ApplicationContext vApplicationContext
                = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

        //manager = vApplicationContext.getBean("UtilisateurManagerImpl", UtilisateurManagerImpl.class);

        //Utilisateur user = new Utilisateur();
        user.setRecall(true);
        user.setPhone("0908067474");
        user.setAdress("10 downing street");
        user.setPassword("passwd");
        user.setId(3);
        user.setLogin("root");
        user.setEmail("root.mail");

    }

    @Test
    public void getUtilisateur() {

        Mockito.lenient().when(pUtilisateur.getLogin()).thenReturn("user1");
        Mockito.lenient().when(pUtilisateur.getLogin()).thenReturn("passwd");

        Assert.assertNotNull(pUtilisateur);

    }

    @Test
    public void listRecall() {

        Assert.assertTrue(listRecall.add(user));

    }

}
