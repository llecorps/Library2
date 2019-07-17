package org.lle.biblio.business.impl.manager;

import org.junit.Before;
import org.junit.Test;
import org.lle.biblio.model.bean.location.Location;
import org.lle.biblio.testbusiness.business.BusinessTestCase;

/**
 * Created by TheAdmin on 11.07.2019.
 */
public class LocationManagerImplTest extends BusinessTestCase {

    private LocationManagerImpl manager = new LocationManagerImpl();

    @Before
    public void setUp() throws Exception {



    }

    @Test
    public void getLocation() throws Exception {

       Location pLocation = manager.getLocation(2);

    }

}