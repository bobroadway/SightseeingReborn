package edu.matc.persistence;

import edu.matc.entity.Zone;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bo on 10/2/2016.
 */
public class ZoneDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all zones
     *
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
     * retrieve a zone given its zone_id
     *
     * @param zone_id the zone_id
     * @return zone
     */
    public Zone getZone(int zone_id) {
        log.info("In getZone()");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Zone zone = (Zone) session.get(Zone.class, zone_id);
        return zone;
    }
}
