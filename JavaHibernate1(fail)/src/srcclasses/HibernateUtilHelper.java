/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srcclasses;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import static org.hibernate.jpa.internal.EntityManagerImpl.LOG;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author L3000n100
 */
public class HibernateUtilHelper {
    private static final SessionFactory sessionFactory = initHibernate();

    private static SessionFactory initHibernate() {     
        try{
            // Create the SessionFactory from hibernate.cfg.xml
            final Configuration config = new Configuration().configure("hibernate.cfg.xml");
            LOG.info("Connection hibernate to URL="+config.getProperty("hibernate.connection.url"));
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            
            return config.buildSessionFactory(serviceRegistry);
        }catch(Throwable ex){
            // log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed. " +ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
