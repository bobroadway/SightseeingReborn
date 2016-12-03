package edu.matc.persistence;

import edu.matc.entity.UserRole;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Bo on 12/3/2016.
 */
public class UserRoleDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * retrieve a userRole given their id
     *
     * @param userName the userName
     * @return userRole
     */
    public UserRole getUserRole(String userName) {
        log.info("In getUserRole()");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        UserRole userRole = (UserRole) session.get(UserRole.class, userName);
        return userRole;
    }

    /**
     * add a userRole
     *
     * @param userRole
     * @return the userName of the inserted userRole
     */
    public String addUserRole(UserRole userRole) {
        log.info("In addUserRole()");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(userRole);
        tx.commit();
        return userRole.getUserName();
    }

    /**
     * delete a userRole by id
     * @param userName the userRole's username
     */
    public void deleteUserRole(String userName) {
        log.info("In deleteUserRole()");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        UserRole userRole = (UserRole) session.get(UserRole.class, userName);
        if(userRole != null) {
            session.delete(userRole);
        }
        session.flush();
        tx.commit();
    }

}
