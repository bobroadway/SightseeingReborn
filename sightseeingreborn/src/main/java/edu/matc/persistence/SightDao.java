package edu.matc.persistence;

import edu.matc.entity.Sight;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Dao used for CRUD operations of the SIGHT table.
 * Created on 10/2/16
 * @author Bo Broadway
 */
public class SightDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Return a list of all sights
     * @return All sights
     */
    public List<Sight> getAllSights() {
        log.info("In getAllSights()");
        List<Sight> sights = new ArrayList<Sight>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        sights = session.createCriteria(Sight.class).list();
        return sights;
    }

    /**
     * retrieve a sight by id
     * @param id the sight's id
     * @return sight
     */
    public Sight getSight(int id) {
        log.info("In getSight()");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Sight sight = (Sight) session.get(Sight.class, id);
        return sight;
    }

    /**
     * add a sight
     * @param sight the sight to add
     * @return the id of the inserted record
     */
    public Integer addSight(Sight sight) {
        log.info("In addSight()");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(sight);
        tx.commit();
        return sight.getId();
    }

    /**
     * delete a sight by id
     * @param id the sight id
     */
    public void deleteSight(int id) {
        log.info("In deleteSight()");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Sight sight = (Sight) session.get(Sight.class, id);
        if(sight != null) {
            session.delete(sight);
        }
        session.flush();
        tx.commit();
    }

    /**
     * Update the sight
     * @param sight the sight to be updated
     */
    public void updateSight(Sight sight) {
        log.info("In updateSight()");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Sight existing = (Sight) session.get(Sight.class, sight.getId());
        if (existing != null) {
            session.merge(sight);
        }
        session.flush();
        tx.commit();
    }

}
