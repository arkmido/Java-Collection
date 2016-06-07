/*
*   Arnel's Burger Ordering System 
*
*   Project version and change logs
*             0.01: extracted menu items as classes and created objects (rough design)
*             0.15: completed the conversion of procedural design to oop (untested/undebugged corner cases)
*             0.2: factored ui class and customer class from main class
*             0.3: refactored codes and some bug fixes
*             0.3.0.1 : remove payment entry and added a simple thread to simulate order processing
*             0.3.1 TODO: create database table to represent objects used(eg. burger, customer, dessert, drink, sides)
*                       : turning to MVC program design
*/
package simpleorderingsystem;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

    public static void main(String[] args) {   
        Customer cust = new Customer();
        try {
            cust.orderItem();
        } catch (InterruptedException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
