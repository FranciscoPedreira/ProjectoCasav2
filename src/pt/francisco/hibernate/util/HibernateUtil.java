/**
 * 
 */
package pt.francisco.hibernate.util;

import org.hibernate.Session;

/**
 * @author Francisco
 *
 */

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	 
    private static SessionFactory buildSessionFactory() {
        try {
        	
            // Create the SessionFactory from hibernate.cfg.xml
        	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            return sessionFactory;
            
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
	
}
