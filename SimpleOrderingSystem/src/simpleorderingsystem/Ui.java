
package simpleorderingsystem;

import java.text.DecimalFormat;
import java.util.ArrayList;
public class Ui extends Thread{
    
    private final DecimalFormat df = new DecimalFormat("#.##");
    
    // declare menu item lists
    private final Burger[] whoppers = new Burger[4];
    private final Burger[] specialBurgers = new Burger[4];
    private final Burger[] chickenBurgers = new Burger[4];
    private final Sides sides[] = new Sides[6];
    private final Desserts desserts[] = new Desserts[3];
    private final Drinks drinks[] = new Drinks[3]; 
    
    ArrayList menuList = new ArrayList();
    
    // UI constructor
    Ui(){   
        initializeMenuItems();
        initializeMenuList();
    }
    
    private void initializeMenuList(){
        menuList.add(whoppers);
        menuList.add(specialBurgers);
        menuList.add(chickenBurgers);
        menuList.add(sides);
        menuList.add(desserts);
        menuList.add(drinks);
    }
    
    private void initializeMenuItems(){
        // Instantiate all menu items
        whoppers[0] = new Burger("Whopper", "Whopper Jr.", 119.00);
        whoppers[1] = new Burger("Whopper", "Whopper", 179.00);
        whoppers[2] = new Burger("Whopper", "3-meat Whopper", 219.00);
        whoppers[3] = new Burger("Whopper", "4-cheese Whopper", 99.00);
        
        specialBurgers[0] = new Burger("Special Burger", "Classic Angus Steakhouse Burger", 219.00);
        specialBurgers[1] = new Burger("Special Burger", "Bacon Angus Steakhouse Burger", 240.00);
        specialBurgers[2] = new Burger("Special Burger", "Bacon Cheese", 199.00);
        specialBurgers[3] = new Burger("Special Burger", "Mushroom Swiss", 199.00);

        chickenBurgers[0] = new Burger("Chicken Royalty", "X-tra Long Chicken", 170.00);
        chickenBurgers[1] = new Burger("Chicken Royalty", "Chicken Crisp Fillet", 109.00);
        chickenBurgers[2]= new Burger("Chicken Royalty", "King's Crunchy Chicken", 165.00);
        chickenBurgers[3] = new Burger("Chicken Royalty", "Meaty Chicken Fillet", 89.00);

        sides[0] = new Sides("Onion Rings", "R", 29.00);
        sides[1] = new Sides("Onion Rings", "M", 49.00);
        sides[2] = new Sides("Onion Rings", "L", 59.00);

        sides[3] = new Sides("Fries", "R", 29.00);
        sides[4] = new Sides("Fries", "M", 49.00);
        sides[5] = new Sides("Fries", "L", 59.00);

        desserts[0] = new Desserts("Hershey's Sundae Pie", 95.00);
        desserts[1] = new Desserts("Espresso Sundae", 49.00);
        desserts[2] = new Desserts("Sundae", 29.00);

        drinks[0] = new Drinks("Coke 1.5L", 65.00);
        drinks[1] = new Drinks("Coke in can", 35.00);
        drinks[2] = new Drinks("Bottled water", 35.00);
    }
    
    protected void finish(double total) throws InterruptedException{
        System.out.println("\nThat will be: \u20B1"+df.format(total)+"\nPlease wait while we prepare your order...");
        Thread.sleep(5000);
        System.out.println("\nYour order's ready!\nThank you for using this application!\nEnjoy your meal!");
    }
    
    protected double getItemPrice(int listIndex, int itemIndex){
        double price = 0.0;
        
        if(listIndex >= 0 && listIndex <= 2){
            Burger objBurg[] = (Burger[]) menuList.get(listIndex);
            price = objBurg[itemIndex].getPrice();
        }else if(listIndex >= 3 && listIndex <= 5){
            switch(listIndex){
                case 3: Sides objSides[] = (Sides[]) menuList.get(listIndex); 
                        price = objSides[itemIndex].getPrice();break;
                case 4: Desserts objDes[]= (Desserts[]) menuList.get(listIndex);
                        price = objDes[itemIndex].getPrice();break;
                case 5: Drinks objDrnk[] = ((Drinks[]) menuList.get(listIndex));
                        price = objDrnk[itemIndex].getPrice();break;
            }
        }
        return price;
    }
    
    // prints the category menu
    protected void printBaseMenu(){
        System.out.println("*** MENU ***\n");
        String items[] = {"Whoppers","Special Burgers","Chicken Burgers","Sides","Desserts", "Drinks"};
        char c = 'a';
        for(String i : items){
            System.out.println(c+"). "+i);
            c++;
        }
    }
    
    // prints menu sub items
    protected void printInfo(Object obj[], int index){
        char ch = 'a';
        switch(index){
            case 0:case 1:case 2:
                        for(Burger b : (Burger[]) obj){
                            System.out.println(ch+"). NAME: "+b.getName());
                            System.out.println("    PRICE: \u20B1"+df.format(b.getPrice()));
                            ch++;
                        }break;
            case 3:
                for(Sides sd : (Sides[]) obj){
                    System.out.println(ch+"). NAME: "+sd.getName()+" "+sd.getSize());
                    System.out.println("    PRICE: \u20B1"+df.format(sd.getPrice()));
                    ch++;
                }break;
            case 4:for(Desserts d : (Desserts[]) obj){
                    System.out.println(ch+"). NAME: "+d.getName());
                    System.out.println("    PRICE: \u20B1"+df.format(d.getPrice()));
                    ch++;
                }break;
            case 5:for(Drinks d : (Drinks[]) obj){
                    System.out.println(ch+"). NAME: "+d.getName());
                    System.out.println("    PRICE: \u20B1"+df.format(d.getPrice()));
                    ch++;
                }break;
        }  
    }
}
