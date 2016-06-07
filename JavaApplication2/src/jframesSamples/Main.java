package jframesSamples;
// simple gui using JFrame
import javax.swing.JFrame;
public class Main {
    public static void main(String[] args){
        Second second = new Second();
        
        // Just sets the default close operation on our window
        second.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        second.setSize(275, 180); // just sets the starting size
        second.setVisible(true);  // sets the window visible
    }
}
