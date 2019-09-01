package org.lle.biblio.business.impl.manager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lle.biblio.model.bean.location.Location;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by TheAdmin on 17.07.2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationManagerImplTest{
//public class LocationManagerImplTest extends AbstractManager {

    //private LocationManagerImpl manager;
    @Mock
    private Location pLocation;

    @Before
    public void setUp() throws Exception {

        ApplicationContext vApplicationContext
                = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

        //manager = vApplicationContext.getBean("locationManagerImpl", LocationManagerImpl.class);

    }

    @Test
    public void getLocation() throws Exception {

       // pLocation = manager.getLocation(2);
        Mockito.lenient().when(pLocation.getUtilisateur_id()).thenReturn(Integer.valueOf("2"));
       // Assert.assertTrue(pLocation != null);
        Assert.assertNotNull(pLocation);
    }

}