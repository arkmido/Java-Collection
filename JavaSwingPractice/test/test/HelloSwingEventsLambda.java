/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Demonstrates the use of Lambda Expressions
 * in event listeners.
 */
package test;

import javax.swing.*;

public class HelloSwingEventsLambda extends JFrame
{
   private JButton btn1 = new JButton("Click Me!");
   private JPanel pnl1 = new JPanel();
   private int ctr = 0;
   
   HelloSwingEventsLambda(){
       this.setSize(400,150);
       this.setTitle("Hello Swing Events Lambda");
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.add(pnl1);
       
       btn1.addActionListener(e -> {
           ctr++;
           btn1.setText(ctr == 1 ? "I've been clicked!" : "I've been clicked "+ctr+" times!");
       });
       
       pnl1.add(btn1);
       this.setVisible(true);
   }
   public static void main(String[] args){ new HelloSwingEventsLambda(); }
}

