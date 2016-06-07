
package simpleorderingsystem;

public class Burger{
    private double price;
    private String type, name;
    private int prepareTime;
    
    protected Burger(String type, String name, double price){
        this.type = type;
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
