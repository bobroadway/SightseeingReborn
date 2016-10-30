package edu.matc.persistence;

import edu.matc.entity.Zone;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Bo on 10/30/2016.
 */
public class ZoneDaoTest {
    private final Logger log = Logger.getLogger(this.getClass());

    ZoneDao dao;
    Zone zone;

    @Before
    public void setup() {
        dao = new ZoneDao();
        zone = new Zone();
    }

    @Test
    public void getAllZones() throws Exception {
        List<Zone> zones = dao.getAllZones();
        assertTrue(zones.size() > 0);
    }

    @Test
    public void getZone() throws Exception {
        zone = dao.getZone(1);
        assertEquals("Ul'dah - Steps of Nald", zone.getName());
    }

}
