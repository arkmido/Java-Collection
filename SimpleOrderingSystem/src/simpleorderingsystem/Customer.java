
package simpleorderingsystem;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer {
    
    private final Ui ui = new Ui();
    private final Scanner sc = new Scanner(System.in);
    private final DecimalFormat df = new DecimalFormat("#.##");
    private double total;
    
    Customer(){
         total = 0.0;
         ui.printBaseMenu();
    }
    
    protected void orderItem() throws InterruptedException{
        String choice;
        boolean doneOrdering = false;
        do{
            System.out.print("\nType \"exit\" to close.\nEnter the letter of your choice: ");
            choice = sc.next();
            if(choice.equalsIgnoreCase("exit"))break;
            int listIndex = callChoiceSubMenu(choice);
            
            if(listIndex == -1){
                ui.printBaseMenu();
            }
            else if(listIndex == -2){
                break;
            }
            else if(listIndex < -2){
                System.err.println("Ooops.. Something went wrong.\nPlease call help.");
                break;
            }
            if(subMenuOrder(listIndex) == -1)
                ui.printBaseMenu();            
            else{
                if(!endOrdering()){
                    ui.printBaseMenu();
                }else{
                   doneOrdering = true;
                   ui.finish(total);
                }
            }
        }while(!doneOrdering);
    }
    
    private boolean endOrdering(){
        boolean end = false;
        do{
            try{
                System.out.print("\nFinish ordering? \"y/n\": ");
                String ch = sc.next();
                if(ch.equalsIgnoreCase("y")){
                    end = true;
                    break;
                }else if(ch.equalsIgnoreCase("n")){
                    System.out.println("\nTotal of items ordered: \u20B1"+total+"\n");
                    end = false;
                    break;
                }
            }catch(Exception e){
                System.out.println("\n\"y\" = yes; \"n\" = no");
            }
        }while(true);
        return end;
    }
    
    private int callChoiceSubMenu(String c){
        System.out.println();
        int index = ((c.toLowerCase()).charAt(0) - 'a') % 26;
        
        if(index <= (ui.menuList.size()-1) && index >= 0){
            ui.printInfo((Object[]) ui.menuList.get(index), index);
        }else{
            System.out.println("**Sorry, these are the only items available.\n");
            return -1;
        }
        System.out.println();
        return index;
    }
    
    // get selected item price
    private double subMenuOrder(int listIndex){
        System.out.print("Type \"back\" to return.\nYour order please: ");
        String c = sc.next();
        if(c.equalsIgnoreCase("back")) return -1;
        
        double quantity = 0.0;
        int index = ((c.toLowerCase()).charAt(0) - 'a') % 26;
        
        if(index <= ((Object[])ui.menuList.get(index)).length -1){
            do{
                try{
                    System.out.print("Please enter item quantity: ");
                    quantity = sc.nextDouble();
                }catch(InputMismatchException e){
                    System.out.println("Numbers only please");
                    sc.next();
                }
                total += (ui.getItemPrice(listIndex, index)) * quantity;
                break;
            }while(true);
        }else{
            System.out.println("**Sorry, these are the only items available.\n");
            return -1;
        }
        return total;
    }
}