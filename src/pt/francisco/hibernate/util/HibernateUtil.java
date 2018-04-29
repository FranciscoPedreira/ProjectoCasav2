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
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    public static SessionFactory getSessionFactory() {
        return buildSessionFactory();
    }

    private static SessionFactory buildSessionFactory() {

        final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }

    public static Session getSession() {
        Session hibernateSession = getSessionFactory().getCurrentSession();
        return hibernateSession;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
	
}
