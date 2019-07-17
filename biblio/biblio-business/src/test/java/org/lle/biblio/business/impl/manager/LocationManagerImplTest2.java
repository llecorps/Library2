package org.lle.biblio.business.impl.manager;

import org.junit.Before;
import org.junit.Test;
import org.lle.biblio.model.bean.location.Location;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by TheAdmin on 17.07.2019.
 */
public class LocationManagerImplTest2 {

    private LocationManagerImpl manager = new LocationManagerImpl();

    @Before
    public void setUp() throws Exception {

        ApplicationContext vApplicationContext
                = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

        manager = new LocationManagerImpl();


    }

    @Test
    public void getLocation() throws Exception {

        Location pLocation = manager.getLocation(2);

    }


}