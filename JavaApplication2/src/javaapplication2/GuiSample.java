package javaapplication2;

import javax.swing.JOptionPane;

public class GuiSample {
        public static void main(String[] args){
            
        int fn = Integer.parseInt(JOptionPane.showInputDialog("Data 1: "));
        
        int sn = Integer.parseInt(JOptionPane.showInputDialog("Data 2: "));

        int sum = fn + sn;

        JOptionPane.showMessageDialog(null,   "Answer is "+sum, "Title", JOptionPane.PLAIN_MESSAGE);

    }
}
