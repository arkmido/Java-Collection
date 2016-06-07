package srcclasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author L3000n100
 */

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MyFirstHibernateApp {
    private String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private String JDBC_URL = "jdbc:derby:db/userdata;create=true";
    private Connection con;
    
    public static void main(String[] args) { 
        MyFirstHibernateApp h = new MyFirstHibernateApp();
        h.start();
        System.exit(0);
    }
    private void start(){
        Scanner sc = new Scanner(System.in);
        Scanner add = new Scanner(System.in);
        int userid = 100;
        do{
            System.out.println("A). Connect DB\nB). Create Tables\n"
                    + "C). Add User\nD). Add Task\nE). Get Full Name\n"
                    + "F). Update Last name\nG). Delete User\n"
                    + "H). Exit");
            String sca =  sc.nextLine();
            if(sca.equalsIgnoreCase("A")) connect();
            else if(sca.equalsIgnoreCase("B")) createTables();
            else if(sca.equalsIgnoreCase("C")){                
                System.out.println("Enter first name: ");
                String firstName = add.nextLine();
                System.out.println("Enter last name: ");
                String lastName = add.nextLine();
                addUser(userid, firstName, lastName);
                userid++;
            }
            else if(sca.equalsIgnoreCase("D")){
                System.out.println("Enter User Id: ");
                int id = add.nextInt();
                System.out.println("Enter Title: ");
                String title = add.nextLine();
                System.out.println("Enter Description: ");
                String description = add.nextLine();
                addTask(id, title, description);
            }
            else if(sca.equalsIgnoreCase("E")){
                System.out.println("Enter first name: ");
                String firstname = add.nextLine();
                getFullName(firstname);
            }
            else if(sca.equalsIgnoreCase("F")){
                System.out.println("Enter id: ");
                int id = add.nextInt();
                System.out.println("Enter new last name: ");
                String newLastName = add.nextLine();
                updateLastName(id, newLastName);
            }
            else if(sca.equalsIgnoreCase("G")){
                System.out.println("Enter id: ");
                int id = add.nextInt();
                User user = new User();
                user.setId(id);
                deleteUser(user);
            }
            else if(sca.equalsIgnoreCase("H")) break;
        }while(true);
    }
    // Hibernate methods
    private void deleteUser(User user){
        Transaction trns = null;
        Session session = HibernateUtilHelper.getSessionFactory().getCurrentSession();
        try{
            trns = session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }catch(RuntimeException e){
            if(trns != null) trns.rollback();
            e.printStackTrace();
        }finally{
            if(session.isOpen() && session != null){
                session.flush();
                session.close();
            }
        }
    }
    private void getFullName(String firstName){
        Transaction trns = null;
        Session session = HibernateUtilHelper.getSessionFactory().getCurrentSession();
        try{
            trns = session.beginTransaction();
            List<User> users = session.createQuery("from users as u where u.first_name = :firstName")
                    .setString("firstName", firstName)
                    .list();
            for(Iterator <User> iter = users.iterator(); iter.hasNext();){
                User user = iter.next();
                System.out.println(user.getFirstName()+" "+user.getLastName());
            }
            trns.commit();
        }catch(RuntimeException e){
            if(trns != null) trns.rollback();
            e.printStackTrace();
        }finally{
            if(session.isOpen() && session != null){
                session.flush();
                session.close();
            }
        }
    }
    private void updateUser(User user){
        Transaction trns = null;
        Session session = HibernateUtilHelper.getSessionFactory().getCurrentSession();
        try{
            trns = session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }catch(RuntimeException e){
            if(trns != null) trns.rollback();
            e.printStackTrace();
        }finally{
            if(session.isOpen() && session != null){
                session.flush();
                session.close();
            }
        }
    }
    private void updateLastName(int id, String lastName){
        Transaction trns = null;
        Session session = HibernateUtilHelper.getSessionFactory().getCurrentSession();
        try{
            trns = session.beginTransaction();
            String hqlUpdate = "update users u set u.last_name = :newLastName where u.id = :oldId";
            session.createQuery(hqlUpdate)
                    .setString("newLastName", lastName)
                    .setInteger("oldId", id)
                    .executeUpdate();
            trns.commit();
                    
        }catch(RuntimeException e){
            if(trns != null) trns.rollback();
            e.printStackTrace();
        }finally{
            if(session.isOpen() && session != null){
                session.flush();
                session.close();
            }
        }
    }
    private void addTask(int userID, String title, String description){
        Transaction trns = null;
        Session session = HibernateUtilHelper.getSessionFactory().getCurrentSession();
        try{
            trns = session.beginTransaction();
            
            Tasks task = new Tasks();
            task.setId(userID);
            task.setTitle(title);
            task.setDescription(description);
            
            session.save(task);
            session.getTransaction().commit();
        }catch(RuntimeException ex){
            if(trns != null) trns.rollback();
            ex.printStackTrace();
        }finally{
            if(session.isOpen() && session != null){
                session.flush();
                session.close();
            }
        }
    }
    private void addUser(int userid, String firstName, String lastName){
        Transaction trns = null;
        Session session = HibernateUtilHelper.getSessionFactory().getCurrentSession();
        try{
            trns = session.beginTransaction();
            
            User user1 = new User();
            user1.setFirstName(firstName);
            user1.setLastName(lastName);
            user1.setId(userid);
            
            session.save(user1);
            session.getTransaction().commit();
        }catch(RuntimeException e){
            if(trns != null) trns.rollback();
            e.printStackTrace();
        }finally{
            if(session.isOpen() && session != null){
                session.flush();
                session.close();
            }
        }
    }
    
    // Database table functions, direct db operations
    private void createTables(){
        testTable();
        try{                        
            if(con == null){
                System.out.println("Connection is null");
                System.exit(0);                
            }
            
            con.createStatement().execute("CREATE TABLE users("
                + "id INT PRIMARY KEY,"
                + "first_name VARCHAR(100), last_name VARCHAR(100))");

            System.out.println("New table users created");
            
            con.createStatement().execute("CREATE TABLE tasks("
                + "id INT NOT NULL PRIMARY KEY,"
                + "user_id INT, title VARCHAR(100),"
                + "description VARCHAR(100))");

            System.out.println("New table tasks created");
                      
        }catch(SQLException e){ System.out.println(e.toString()); }
    }
    private void testTable(){
        try{
            DatabaseMetaData dbmd = con.getMetaData();
            ResultSet rs1 = dbmd.getTables(null, "APP", "users", null);
            ResultSet rs2 = dbmd.getTables(null, "APP", "tasks", null);
            if(!rs1.next()){
                con.createStatement().execute("DROP TABLE users");
                System.out.println("Existing table users dropped");
            }
            if(!rs2.next()){
                con.createStatement().execute("DROP TABLE tasks");
                System.out.println("Existing table tasks dropped");
            }
        }catch(SQLException e){System.out.println(e.getMessage());}
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
