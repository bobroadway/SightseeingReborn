package edu.matc.persistence;

import edu.matc.entity.Zone;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Dao used for reading from the ZONE table.
 * Created on 10/2/16
 * @author Bo Broadway
 */
public class ZoneDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Return a list of all zones
     * @return All zones
     */
    public List<Zone> getAllZones() {
        log.info("In getAllZones()");
        List<Zone> zones = new ArrayList<Zone>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        zones = session.createCriteria(Zone.class).list();
        return zones;
    }

    /**
     * retrieve a zone by zoneId
     * @param zoneId the zoneId
     * @return zone
     */
    public Zone getZone(int zoneId) {
        log.info("In getZone()");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Zone zone = (Zone) session.get(Zone.class, zoneId);
        return zone;
    }
}
