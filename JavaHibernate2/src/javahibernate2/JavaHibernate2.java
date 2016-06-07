/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahibernate2;

/**
 *
 * @author L3000n100
 */


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

public class JavaHibernate2 {
    private static final Logger LOG = Logger.getLogger(JavaHibernate2.class.getClass());
    private final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private final String JDBC_URL = "jdbc:derby:db/USERS;create=true";
    private Connection con;
    
    public static void main(String[] args) {
        JavaHibernate2 jh = new JavaHibernate2();
        jh.connect();
        
        Transaction tx = null;
        Session session = jh.initHibernate().getCurrentSession();
        
        try{
            tx = session.beginTransaction();
            UserClass user = new UserClass();
            user.setName("Sample2");
            user.setId(105);
            
            session.save(user);
            session.getTransaction().commit();
        }catch(RuntimeException e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }finally{
            if(session.isOpen() && session != null){
                session.flush();
                session.close();
            }
        }
    }

    public SessionFactory initHibernate(){
        try{
            final Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            LOG.info("Connection to hibernate URL = "+config.getProperty("hibernate.connection.url"));
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

            return config.buildSessionFactory(serviceRegistry);
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
    
     private void connect(){
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(JDBC_URL);
            if(con != null){
                System.out.println("Connected to the Database");
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
