
package test;

import javax.swing.*;
import java.awt.event.*;

public class HelloSwingRadioButton extends JFrame
{
   private JRadioButton small = new JRadioButton("Small");
   private JRadioButton medium = new JRadioButton("Medium");
   private JRadioButton large = new JRadioButton("Large");
   
   private JCheckBox pepperoni = new JCheckBox("Pepperoni");
   private JCheckBox mushrooms = new JCheckBox("Mushrooms");
   private JCheckBox anchovies = new JCheckBox("Anchovies");
   
   private JButton btnok = new JButton("OK");
   private JPanel pnl1 = new JPanel();
   
   HelloSwingRadioButton(){
       this.setSize(300, 300);
       this.setTitle("Pizza");
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setLocationRelativeTo(null);
       
       ButtonGroup rbtngrp = new ButtonGroup();
       rbtngrp.add(small);
       rbtngrp.add(medium);
       rbtngrp.add(large);
       
       pnl1.add(small);
       pnl1.add(medium);
       pnl1.add(large);
       
       pnl1.add(pepperoni);
       pnl1.add(mushrooms);
       pnl1.add(anchovies);
       
       pnl1.add(btnok);
       
       btnok.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               
            }
        });
       
       this.add(pnl1);
       this.setVisible(true);
   }
   
   public static void main(String[] args){ new HelloSwingRadioButton(); }
}
