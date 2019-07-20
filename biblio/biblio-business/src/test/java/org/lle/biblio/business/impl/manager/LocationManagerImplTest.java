package org.lle.biblio.business.impl.manager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.lle.biblio.model.bean.location.Location;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by TheAdmin on 17.07.2019.
 */
public class LocationManagerImplTest extends AbstractManager {

    private LocationManagerImpl manager;
    private Location pLocation;

    @Before
    public void setUp() throws Exception {

        ApplicationContext vApplicationContext
                = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

        manager = vApplicationContext.getBean("locationManagerImpl", LocationManagerImpl.class);

    }

    @Test
    public void getLocation() throws Exception {

        pLocation = manager.getLocation(2);
        Assert.assertTrue(pLocation != null);
    }

}