/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_basic;

/**
 *
 * @author L3000n100
 */

import view.mvc_view;
import model.mvc_model;
import controller.mvc_controller;

public class MVC_Basic {
    
    MVC_Basic(){
        mvc_view theView = new mvc_view();
        mvc_model theModel = new mvc_model();
        mvc_controller theController = new mvc_controller(theView, theModel);
        
        theView.setVisible(true);
    }
    
    public static void main(String[] args) {
        new MVC_Basic();
    }
    
}
