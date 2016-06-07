/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author L3000n100
 */
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;

public class MovieListing {
    public static void main(String[] args) {
        new MovieListing().start(); 
    }
    private void start(){
        do{
            System.out.println("\nA). Display Movies\n"
                              +"B). Add Movie\n"
                              +"C). Update Movie\n"
                              +"D). Delete Movie\n"
                              +"E). Exit");
                              
            String a = sc.nextLine();
            if(a.equalsIgnoreCase("a"))
                displayMovies();
            else if(a.equalsIgnoreCase("b"))
                addMovie();
            else if(a.equalsIgnoreCase("c")) n();
            else if(a.equalsIgnoreCase("d")) n();
            else if(a.equalsIgnoreCase("e")) break;
            else System.out.println("Invalid input.\n");
        }while(true);
        
        System.exit(0);
    }
    private MovieListing(){
        DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        JDBC_URL = "jdbc:derby:movies;create=true";
        conn = getConnection();
        nf = NumberFormat.getCurrencyInstance();
        sc = new Scanner(System.in);
    }
    private Connection getConnection(){
        Connection con = null;
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(JDBC_URL);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return con;
    }
    private void displayMovies(){
        ResultSet movies = getMovies();
        try{
            while(movies.next()){
                Movie m = getMovie(movies);
                String display = Integer.toString(m.year);
                display += ": "+m.title;
                display += " ("+nf.format(m.price)+")";
                System.out.println(display);
            }
        }catch(SQLException e){System.out.println(e.getMessage());}
    }
    private ResultSet getMovies(){
        try{
            Statement s = conn.createStatement();
            String query = "SELECT Title, MovieYear, Price FROM movielist "
                    + "ORDER BY MovieYear";
            ResultSet rows = s.executeQuery(query);
            return rows;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    private Movie getMovie(ResultSet movies){
        try{
            String title = movies.getString("Title");
            int year = movies.getInt("MovieYear");
            double price = movies.getDouble("Price");
            return new Movie(title, year, price);
        }catch(SQLException e){System.out.println(e.getMessage());}
        return null;
    }
    private void addMovie(){
        System.out.println("Title: ");
        String title = sc.nextLine();
        System.out.println("Year: ");
        int year = sc.nextInt();
        System.out.println("Price: ");
        Double price = sc.nextDouble();
        try{
            Statement s = conn.createStatement();
            String query = "INSERT INTO movielist(Title, MovieYear, Price)"
                    + "VALUES ('"+title+"', "+year+", "+price+")";
            if(s.executeUpdate(query) > 0){
                 System.out.println("Added successfully");
            }else{
                System.out.println("Error occured");
            }   
        }catch(SQLException e){System.out.println(e.getMessage());}
    }
    private static void n(){}
    
    
    final private String DRIVER;
    final private String JDBC_URL;
    private Connection conn;
    private final NumberFormat nf;
    Scanner sc;
    
    //-------------------------------
    private static class Movie{
        private String title;
        private int year;
        private double price;
        
        Movie(String title, int year, double price){
            this.title = title;
            this.year = year;
            this.price = price;
        }
    }
}
