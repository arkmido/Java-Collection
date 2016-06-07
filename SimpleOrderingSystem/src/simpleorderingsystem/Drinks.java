
package simpleorderingsystem;

public class Drinks {
    private String name;
    private double price;
    private int prepareTime;
    
    public Drinks(String name, double price){
        this.name = name;
        this.price = price;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getName(){
        return name;
    }
}
