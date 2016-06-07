/*
*   This is a simulation of a ticking timer using a timer
*   and demonstration of using inner classes.
*/

package Javaclassespractice;

import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTick {
    
    private static String tickMessage = "tick...";
    private static String tockMessage = "tock...";
    
    public static void main(String args[]){
        TimerTick t = new TimerTick();
        TimerTicker.hello();
       // t.go();
    }
    private static void go(){
        Timer t = new Timer(1000,new TimerTicker());
        t.start();
        JOptionPane.showMessageDialog(null, "Click OK to exit application");
        System.exit(0);
    }
    
    static class TimerTicker implements ActionListener{
        private boolean tick = true;
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(tick ? tickMessage : tockMessage);
            tick = !tick;
        }
        public static void hello(){
            System.out.println("Hello");
            go();
        }
        
    }
}
