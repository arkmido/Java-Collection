
package simpleorderingsystem;

public class Desserts {
    private String name;
    private double price;
    private int prepareTime;
    
    public Desserts(String name, double price){
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
