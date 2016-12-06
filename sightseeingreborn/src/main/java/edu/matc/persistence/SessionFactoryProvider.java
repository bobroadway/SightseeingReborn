package edu.matc.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Session Factory Provider class for implementing Hibernate.
 * Created on 10/2/16
 * @author Bo Broadway
 */
public class SessionFactoryProvider {

    private static SessionFactory sessionFactory;

    /**
     * Method to create a SessionFactory.
     */
    public static void createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    /**
     * Getter for SessionFactory.
     * @return a sessionFactory
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            createSessionFactory();
        }
        return sessionFactory;
    }

}
