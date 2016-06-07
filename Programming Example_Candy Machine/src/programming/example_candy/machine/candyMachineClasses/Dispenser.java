package programming.example_candy.machine.candyMachineClasses;

public class Dispenser {
    private int numberOfItems;
    private int cost;
    
    public Dispenser(int setNoOfItems, int setCost){
        numberOfItems = setNoOfItems >= 0 ? setNoOfItems : 50;
        cost = setCost >= 0 ? setCost : 50;
    }
    public Dispenser(){
        numberOfItems = 50;
        cost = 50;
    }
    public void makeSale(){
        numberOfItems--;
    }
    public int getProductCost(){
        return cost;
    }
    public int getCount(){
        return numberOfItems;
    }
}
