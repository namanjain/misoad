package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml, deprecated but works for now
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // implement loggers
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    public static void returnSession(Session session) {
        if(session != null) {
            session.close();
        }
    }

    public static void shutdown() {
        // call this when application shuts down
        // Close caches and connection pools
        getSessionFactory().close();
    }

}
