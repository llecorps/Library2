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

import static org.mockito.Mockito.*;

/**
 * Created by TheAdmin on 17.07.2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationManagerImplTest{

    @Mock
    private Location pLocation;

    private  LocationManagerImpl pLocationManager = mock(LocationManagerImpl.class);

    @Before
    public void setUp() throws Exception {

        ApplicationContext vApplicationContext
                = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");
    }

    @Test
    public void getLocation() throws Exception {

       // pLocation = manager.getLocation(2);
        Mockito.lenient().when(pLocation.getUtilisateur_id()).thenReturn(Integer.valueOf("2"));
       // Assert.assertTrue(pLocation != null);
        Assert.assertNotNull(pLocation);
    }
    @Test
    public void getNbreLocation(){

        when(pLocationManager.getNbreLocation(1)).thenReturn(5);
        Assert.assertEquals(pLocationManager.getNbreLocation(1),5);
    }
    @Test
    public void addEmprunt(){

        pLocationManager.addEmprunt(pLocation);
        verify(pLocationManager, times(1)).addEmprunt(pLocation);
    }
    @Test
    public void addNotif(){

        pLocationManager.addNotif("2019-09-31", 1);
        verify(pLocationManager, times(1)).addNotif("2019-09-31", 1);
    }
    @Test
    public void delLoc(){

        pLocationManager.delLoc(pLocation);
        verify(pLocationManager, times(1)).delLoc(pLocation);


    }
    @Test
    public void addProlo(){

        pLocationManager.addProlo("2019-09-31", 1);
        verify(pLocationManager, times(1)).addProlo("2019-09-31", 1);
    }
    @Test
    public void getExpiredate(){

        when(pLocationManager.getExpiredate(1)).thenReturn("2019-09-30");
        Assert.assertEquals(pLocationManager.getExpiredate(1),"2019-09-30");
    }

}