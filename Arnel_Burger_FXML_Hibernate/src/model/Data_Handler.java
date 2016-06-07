/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author L3000n100
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

public class Data_Handler {
    private final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private final String JDBC_URL = "jdbc:derby:db/MEALS;create=true;user=test;password=pass";
    private Connection conn;
    
    private final Logger LOG = Logger.getLogger(Data_Handler.class.getClass());
    Transaction trns = null;
    Session ses;
    
    private List<Burger> burgers;
    private List<Side_Drink> side_drinks;
    private List<Dessert> desserts;
    
    
    public List<Burger> getBurgers(){
        ses = getSessionFactory().getCurrentSession();
        burgers = (List<Burger>) pull("Burger");
        return burgers;
    }
    public List<Dessert> getDesserts(){
        ses = getSessionFactory().getCurrentSession();
        desserts = (List<Dessert>) pull("Dessert");
        return desserts;
    }
    public List<Side_Drink> getSides_Drinks(){
        ses = getSessionFactory().getCurrentSession();
        side_drinks = (List<Side_Drink>) pull("Side_Drink");
        return side_drinks;
    }
    
    private List pull(String classname){
        
        List<Object> results = null;
       
        try{
            trns = ses.beginTransaction();
            String hql = "FROM "+classname;
            Query q = ses.createQuery(hql);
            results = q.list();
           
        }catch(RuntimeException e){
            if(trns != null) trns.rollback();
            e.printStackTrace();
        }finally{
            if(ses.isOpen() && ses != null){
                ses.flush();
                ses.close();
            }
        }
        return results;
    }

    private SessionFactory getSessionFactory(){
        try{
            final Configuration config = new Configuration();
            config.configure("mealsHibernate.cfg.xml");
            LOG.info("Connection to hibernate URL = "+config.getProperty("hibernate.connection.url"));
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

            return config.buildSessionFactory(serviceRegistry);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void disconnect(){
        try{
            conn.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Data_Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void connect(){
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(JDBC_URL);
            if(conn != null) System.out.println("Connected to database.");
        }catch(ClassNotFoundException |  SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void createTables(){
        try{
            if(conn == null){
                System.out.println("Connection is null");
                System.exit(0); 
            }
            String tableBurgers = "CREATE TABLE BURGERS(id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
                                        "price DECIMAL(10,2), type VARCHAR(50), name VARCHAR(100))";
            String tableDesserts = "CREATE TABLE DESSERTS(id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
                                        "price DECIMAL(10,2), name VARCHAR(100))";
            String tableSidesDrinks = "CREATE TABLE SIDES_DRINKS(id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
                                        "price DECIMAL(10,2), name VARCHAR(100))";
            
            conn.createStatement().execute(tableBurgers);
            conn.createStatement().execute(tableDesserts);
            conn.createStatement().execute(tableSidesDrinks);
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void insertDataToTables(){
        try{
            if(conn == null){
                System.out.println("Connection is null");
                System.exit(0); 
            }
            String insertBurgers = "INSERT INTO BURGERS (TYPE, NAME, PRICE) VALUES" +
                                            "('Whopper', 'Whopper Jr.', 119.00)," +
                                            "('Whopper', 'Whopper', 179.00)," +
                                            "('Whopper', '3-meat Whopper', 219.00)," +
                                            "('Whopper', '4-cheese Whopper', 99.00)," +
                                            "('Special Burger', 'Classic Angus Steakhouse Burger', 299.00)," +
                                            "('Special Burger', 'Bacon Angus Steakhouse Burger', 240.00)," +
                                            "('Special Burger', 'Bacon Cheese', 119.00)," +
                                            "('Special Burger', 'Mushroom Swiss', 199.00)";
            
            String insertDesserts = "INSERT INTO DESSERTS (NAME, PRICE) VALUES" +
                                            "('Hershey_s Sundae Pie', 95.00)," +
                                            "('Espresso Sundae', 49.00)," +
                                            "('Sundae', 29.00)";
            
            String insertSidesDrinks = "INSERT INTO SIDES_DRINKS (NAME, PRICE) VALUES" +
                                            "('Onion Rings R', 29.00)," +
                                            "('Onion Rings M', 49.00)," +
                                            "('Onion Rings L', 599.00)," +
                                            "('Fries R', 29.00)," +
                                            "('Fries M', 49.00)," +
                                            "('Fries L', 59.00)," +
                                            "('Coke 1.5L', 65.00)," +
                                            "('Coke in can', 35.00)," +
                                            "('Bottled water', 35.00)";
            
            conn.createStatement().execute(insertBurgers);
            conn.createStatement().execute(insertDesserts);
            conn.createStatement().execute(insertSidesDrinks);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
