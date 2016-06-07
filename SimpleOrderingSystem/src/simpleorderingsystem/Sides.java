
package simpleorderingsystem;

public class Sides {
    private String name, size;
    private double price;
    private int prepareTime;
    
    public Sides(String name, String size, double price){
        this.name = name;
        this.price = price;
        this.size = size;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSize(){
        return size;
    }
}
