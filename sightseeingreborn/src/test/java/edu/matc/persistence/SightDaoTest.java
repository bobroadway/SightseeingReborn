package edu.matc.persistence;

import edu.matc.entity.Sight;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Bo on 10/29/2016.
 */
public class SightDaoTest {
    private final Logger log = Logger.getLogger(this.getClass());

    SightDao dao;
    Sight sight;
    Integer sightId01;
    Integer sightId02;
    Integer sightId03;

    @Before
    public void setup() {
        dao = new SightDao();
        sight = new Sight(1, "Test Sight", 1, 1, "admin");
        sightId01 = dao.addSight(sight);
        sightId02 = dao.addSight(sight);
        sightId03 = dao.addSight(sight);

    }

    @Test
    public void getAllSights() throws Exception {
        List<Sight> sights = dao.getAllSights();
        assertTrue(sights.size() > 0);
    }

    @Test
    public void getSight() throws Exception {
        sight = dao.getSight(sightId01);
        assertEquals("Test Sight", sight.getName());
    }

    @Test
    public void addSight() throws Exception {
        Integer testId = dao.addSight(sight);
        assertEquals(sight.getName(), dao.getSight(testId).getName());
        dao.deleteSight(testId);
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
        Sight sightToUpdate = dao.getSight(sightId02);
        Integer originalCordX = sightToUpdate.getCordX();
        assertNotEquals(new Integer(20), originalCordX);
        sightToUpdate.setCordX(20);
        dao.updateSight(sightToUpdate);
        assertEquals(new Integer(20), dao.getSight(sightId02).getCordX());

        sightToUpdate.setCordX(originalCordX);
        dao.updateSight(sightToUpdate);
    }

    @After
    public void cleanUp() {
        dao.deleteSight(sightId01);
        dao.deleteSight(sightId02);
        dao.deleteSight(sightId03);
    }

}
