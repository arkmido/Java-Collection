/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
/*
 * Demonstrates how to modify exit frame's exit button
 */

import javax.swing.*;
import java.awt.event.*;

public class HelloSwingModifiedExit extends JFrame
{
    private JButton btn1 = new JButton("Click Me!"), exitButton = new JButton("Exit");
    private JPanel panel1 = new JPanel();
    private int ctr = 0;
    
    HelloSwingModifiedExit(){
        this.setSize(400, 150);
        this.setTitle("Swing Modified Exit");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        // using the Window adapter class instead the interface
        // to avoid implementing all unwanted methods.
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                exitButton.doClick();
            }
        });
        
        btn1.addActionListener(e -> {
            ctr++;
            btn1.setText(ctr == 1 ? "I've been clicked!" : "I've been clicked "+ctr+" times!");
        });
        
        exitButton.addActionListener(e -> {
            if(ctr >= 5)System.exit(0);
            JOptionPane.showMessageDialog(null, "You must click the button 5 times!", "OOPSS", JOptionPane.ERROR_MESSAGE);    
        });
        
        panel1.add(btn1);
        panel1.add(exitButton);
        
        this.add(panel1);
        this.setVisible(true);
        
    }
    
    public static void main(String[] args){ new HelloSwingModifiedExit(); }
}

