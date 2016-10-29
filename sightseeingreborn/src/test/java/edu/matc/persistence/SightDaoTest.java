package edu.matc.persistence;

import edu.matc.entity.Sight;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Bo on 10/29/2016.
 */
public class SightDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    SightDao dao;
    Sight sight;
    Sight sightToDelete;

    @Before
    public void setup() {
        dao = new SightDao();
        sight = new Sight();

    }

    @Test
    public void getAllSights() throws Exception {
        List<Sight> sights = dao.getAllSights();
        assertTrue(sights.size() > 0);
    }

    @Test
    public void getSight() throws Exception {
        sight = dao.getSight(1);
        assertEquals("Test Sight", sight.getName());
    }

    @Test
    public void addSight() throws Exception {
        sight.setZoneId(23);
        sight.setName("Test Sight");
        sight.setCordX(10);
        sight.setCordY(10);
        sight.setUserName("admin");
        assertEquals(Integer.valueOf(1), dao.addSight(sight));
    }

    @Test
    public void deleteSight() {
        Sight sightToDelete = new Sight(1, "Delete Sight", 1, 1, "admin");

        Integer newId = dao.addSight(sightToDelete);
        assertNotNull(newId);

        dao.deleteSight(newId);
        assertEquals(null, dao.getSight(newId));
    }

    @Test
    public void updateSight() throws Exception {
        Sight sightToUpdate = dao.getSight(1);
        Integer originalCordX = sightToUpdate.getCordX();
        assertNotEquals(new Integer(20), originalCordX);
        sightToUpdate.setCordX(20);
        dao.updateSight(sightToUpdate);
        assertEquals(new Integer(20), dao.getSight(1).getCordX());

        sightToUpdate.setCordX(originalCordX);
        dao.updateSight(sightToUpdate);
    }

    @After
    public void cleanUp() {
        // clean up
    }

}
