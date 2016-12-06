package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Dao used for CRUD operations of the USER table.
 * Created on 10/2/16
 * @author Bo Broadway
 */
public class UserDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Return a list of all users
     * @return All users
     */
    public List<User> getAllUsers() {
        log.info("In getAllUsers()");
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();
        return users;
    }

    /**
     * retrieve a user by userName
     * @param userName the userName
     * @return user
     */
    public User getUser(String userName) {
        log.info("In getUser()");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = (User) session.get(User.class, userName);
        return user;
    }

    /**
     * add a user
     * @param user a user object
     * @return the id of the inserted record
     */
    public String addUser(User user) {
        log.info("In addUser()");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        return user.getUserName();
    }

    /**
     * delete a user by userName
     * @param userName the user's userName
     */
    public void deleteUser(String userName) {
        log.info("In deleteUser()");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        User user = (User) session.get(User.class, userName);
        if(user != null) {
            session.delete(user);
        }
        session.flush();
        tx.commit();
    }

    /**
     * Update the user
     * @param user
     */
    public void updateUser(User user) {
        log.info("In updateUser()");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        User existing = (User) session.get(User.class, user.getUserName());
        if (existing != null) {
            session.merge(user);
        }
        session.flush();
        tx.commit();
    }

}