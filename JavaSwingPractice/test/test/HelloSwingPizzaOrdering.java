package test;

/**
 *
 * @author L3000n100
 * Demonstrates the use of Swing classes to a simple application
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;

public class HelloSwingPizzaOrdering extends JFrame{
    
    private JPanel sizepnl, toppnl, mainpnl;
    private JButton btnok;
    private JRadioButton rbsmall, rbmedium, rblarge;
    private JCheckBox cbpep, cbmush, cbanch;
    private ButtonGroup sizeGroup;
    private Border sizeborder, toppingsborder;
    
    HelloSwingPizzaOrdering(){
        
        this.setSize(320,200);
        this.setTitle("Order Your Pizza");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        initializeObjects();
        
        sizeGroup.add(rbsmall);
        sizeGroup.add(rbmedium);
        sizeGroup.add(rblarge);
        
        sizepnl.add(rbsmall);
        sizepnl.add(rbmedium);
        sizepnl.add(rblarge);
        sizepnl.setBorder(sizeborder);
        
        toppnl.add(cbpep);
        toppnl.add(cbmush);
        toppnl.add(cbanch);
        toppnl.setBorder(toppingsborder);
        
        mainpnl.add(sizepnl);
        mainpnl.add(toppnl);
        mainpnl.add(btnok);
        
        this.add(mainpnl);
        this.setVisible(true);
    }
    
    private void btnokClick(ActionEvent e) {
        String tops = "", msg = "You ordered ";
        
        if(cbpep.isSelected()) tops += "-\tPepperoni\n";
        if(cbmush.isSelected()) tops += "-\tMushrooms\n";
        if(cbanch.isSelected()) tops += "-\tAnchovies\n";
        
        if(rbsmall.isSelected()) msg += "a small pizza with ";
        if(rbmedium.isSelected()) msg += "a medium pizza with ";
        if(rblarge.isSelected()) msg += "a large pizza with ";
        
        if(tops.equals("") && msg.equals("You ordered ")) msg += "nothing!";
        else if(tops.equals("")) msg += "no toppings";
        else msg += "\nthe following toppings:\n\n" +tops;
        
        JOptionPane.showMessageDialog(btnok, msg+"\n", "Your Order", 1);
        clearSelections();
    }
    private void clearSelections(){
        cbpep.setSelected(false);
        cbmush.setSelected(false);
        cbanch.setSelected(false);
        rbsmall.setSelected(true);
    }
    private void initializeObjects(){
        btnok = new JButton("OK");
        btnok.addActionListener((ActionEvent e) -> {
            btnokClick(e);
        });
         
        mainpnl = new JPanel();
        sizepnl = new JPanel();
        toppnl = new JPanel();
        
        rbsmall = new JRadioButton("Small");
        rbmedium = new JRadioButton("Medium");
        rblarge = new JRadioButton("Large");
        
        cbpep = new JCheckBox("Pepperoni");
        cbmush = new JCheckBox("Mushrooms"); 
        cbanch = new JCheckBox("Anchovies");
        
        sizeGroup = new ButtonGroup();
        
        sizeborder = BorderFactory.createTitledBorder("Sizes");
        toppingsborder = BorderFactory.createTitledBorder("Toppings");
    }
    public static void main(String[] args){ new HelloSwingPizzaOrdering(); }
}
