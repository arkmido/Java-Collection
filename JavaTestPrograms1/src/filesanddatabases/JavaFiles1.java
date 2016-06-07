/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesanddatabases;

import java.io.File;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JavaFiles1 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String jdb_url = "jdbc:derby:filesanddatabases/movies;create=true";
        
        
        Connection conn = DriverManager.getConnection(jdb_url);
        conn.createStatement().execute("drop table movies");
        conn.createStatement().execute("create table movies"
                + "id int not null auto_increment,"
                + "title varchar(50),"
                + "year int,"
                + "price decimal,"
                + "primary key(id)");
        conn.createStatement().execute("insert into movies (title, year, price) values"
                + "('Its a wonderful life', 1946, 14.95)");
        
        System.out.println("Table created");
        
        
        
        
        
        
        /*
        String path = "C:\\Users\\L3000n100\\Documents\\NetBeansProjects\\JavaTestPrograms1\\src\\filesanddatabases\\";
        String filename = "hits.log";
        
        File f = new File(path);
        
        if(f.isDirectory()){
            File[] files = f.listFiles();
            for(File file : files){
                System.out.println(file.getName());
            }
        }
        */
        /*
        // file constructor, the file to be created is still in memory
        File f = new File(path+filename);
        
        // checks if the directory or file exists
        System.out.println(f.exists() ? "File "+f.toString()+" exists" : 
                                        "File doesn't exists");
        
        // checks whether the paramater inside File() is a directory
        System.out.println(f.isDirectory() ? "Path is a directory" : "");
        // or this to check if the paramater is already a file
        //System.out.println(f.isFile() ? "Supplied constructor parameter is a File":"");
        
        // method returns true if file creationg succeeds
        System.out.println(f.createNewFile() ? "File created" : 
                                               "File cannot be created");
        
        // checks if the file is modfiable        
        System.out.println((f.canWrite()) ? "File can be modified" :
                                            "File cannot be modified");
        
        // Tests if the file object can be renamed to a new file
        if(f.renameTo(new File(path+"file.txt")))
            System.out.println("File renamed successfully");
        else
            System.out.println("File cannot be renamed!");
        
        System.out.println("\n"+f.getAbsolutePath());
        */
    }
}
