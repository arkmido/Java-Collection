package package1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author L3000n100
 */
public class MainClass {
    final private String Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final private String JDBC_URL = "jdbc:derby:movies;create=true";
    private Connection conn;
    
    MainClass(){
        getConnected();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("'yes' to insert row and retrieve all titles\n'no' to just retrieve titles"
                + "\n'create' to create new table");
        String ans = sc.nextLine();
        
        if(ans.equalsIgnoreCase("yes")){
            try{
                System.out.println("Enter title: ");
                String title = sc.nextLine();
                System.out.println("Enter price: ");
                Double price = sc.nextDouble();
                
                conn.createStatement().execute("INSERT INTO Movie(title, price)"
                + "VALUES('"+title+"', "+price+")");
            }catch(SQLException e){System.out.println(e.toString());}
            
        }else if(ans.equalsIgnoreCase("no")){
            try{
                Statement s = conn.createStatement();
                ResultSet rows = s.executeQuery("SELECT * FROM Movie");

                while(rows.next()){
                    String msg = rows.getString("Title");
                    System.out.println(msg);
                }
            }catch(SQLException e){
                System.out.println(e.toString());
                System.exit(0);
            }
        }else if(ans.equalsIgnoreCase("create")){
            try{
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, "APP", "Movie", null);

                if(!rs.next()){
                    conn.createStatement().execute("DROP TABLE Movie");
                    System.out.println("Existing table Movie dropped");
                }
            }catch(Exception e){
                System.out.println(e.toString());
            }
            createTable("Movie");
        }
    }
    private void createTable(String tblname){
        try{                        
            if(conn == null){
                System.out.println("Connection is null");
                System.exit(0);                
            }
            
            conn.createStatement().execute("CREATE TABLE "+tblname+"("
                + "id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
                + "title VARCHAR(50), price DECIMAL(8,2))");

            conn.createStatement().execute("INSERT INTO "+tblname+"(title, price)"
            + "VALUES('Its a Wonderful Life 1946', 14.65)"); 

            System.out.println("New table '"+tblname+"' created");
                      
        }catch(SQLException e){
            System.out.println(e.toString());
            System.exit(0);
        }
    }
    private void getConnected(){
        try{
            Class.forName(Driver);
            conn = DriverManager.getConnection(JDBC_URL);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.toString());
            System.exit(0);
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {new MainClass();}
}
