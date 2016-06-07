/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class mvc_view extends JFrame{
    
    private JTextField firstNumber = new JTextField(10);
    private JTextField secondNumber  = new JTextField(10);
    private JLabel additionLabel = new JLabel("+");
    private JButton calculateButton = new JButton("calculate");
    private JTextField calculationSolution = new JTextField(10);
    
    public mvc_view(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(firstNumber);
        panel.add(additionLabel);
        panel.add(secondNumber);
        panel.add(calculateButton);
        panel.add(calculationSolution);
        
        this.setSize(600, 300);
        this.add(panel);
    }
    public int getFirstNumber(){
        return Integer.parseInt(firstNumber.getText());
    }
    public int getSecondNumber(){
        return Integer.parseInt(secondNumber.getText());
    }
    public int getCalculationSolution(){
        return Integer.parseInt(calculationSolution.getText());
    }
    public void setCalculateSolution(int calculationValue){
        calculationSolution.setText(Integer.toString(calculationValue));
    }
    public void addCalculationListener(ActionListener listenerForCalculateButton){
        calculateButton.addActionListener(listenerForCalculateButton);
    }
    public void displayError(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
}
