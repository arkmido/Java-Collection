package javaswingpractice;

// Using JFrame object to create a window
import javax.swing.*;
public class UnangClass{
    public static void main(String args[]){
        JFrame jf = new JFrame("Arnel's Burger");   // instance of the JFrame class
        
        jf.setSize(816, 624);           // sets JFrame size; the window
        jf.setLocationRelativeTo(null); // set the location to center
        jf.setTitle("Hello World!");
        jf.setVisible(true);            // window is visible
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // x button closes app
    }
}



/*  Creating JFrame by extending JFrame class */
/*
import javax.swing.*;

public class UnangClass extends JFrame {
    public static void main(String[] args){
        new UnangClass();
    }
    public UnangClass(){
        this.setSize(250,100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Hello World!");
        this.setVisible(true);
    }
}
*/