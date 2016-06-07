/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.mvc_view;
import model.mvc_model;

public class mvc_controller {
    
    mvc_view theView = new mvc_view();
    mvc_model theModel = new mvc_model();
    
    public mvc_controller(mvc_view theView, mvc_model theModel){
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addCalculationListener(new CalculateListener());
    }

    private class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                theModel.addTwoNumbers(theView.getFirstNumber(), theView.getSecondNumber());
                theView.setCalculateSolution(theModel.getCalculationValue());
            }catch(NumberFormatException ex){
                theView.displayError("You need to add 2 integers");
            }
        }
    }
}
