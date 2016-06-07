/*
 *      This program demonstrates the use of anonymous classes from the TimerTick program
 *      -anonymous classes follows the rules of inner classes.
 *      -anonymous classes can't be static.
 */
package Javaclassespractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JOptionPane;

public class AnonymousClassTimerTick {
    private final String tick = "tick..", tock = "tock..";
    
    public static void main(String args[]){
        AnonymousClassTimerTick an = new AnonymousClassTimerTick();
        an.go();
    }
    void go(){
        Timer t1 = new Timer(1000, new ActionListener(){
            private boolean tick = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tick ? AnonymousClassTimerTick.this.tick : 
                        AnonymousClassTimerTick.this.tock );
                tick = !tick;
            }
        });
        t1.start();
        JOptionPane.showMessageDialog(null, "OK to close");
        System.exit(0);
    }
    
}
