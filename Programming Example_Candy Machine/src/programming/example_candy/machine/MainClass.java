package programming.example_candy.machine;

import java.io.*;
import  programming.example_candy.machine.candyMachineClasses.*;
public class MainClass {

    static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        CashRegister cashRegister = new CashRegister();
        Dispenser candy = new Dispenser(100,50);
        Dispenser chips = new Dispenser(100,65);
        Dispenser gums = new Dispenser(75,45);
        Dispenser cookies = new Dispenser(100,85);
        int choice;
        showSelection();
        choice = Integer.parseInt(keyboard.readLine());
        while(choice != 9){
            switch(choice){
                case 1: sellProduct(candy, cashRegister); break;
                case 2: sellProduct(chips, cashRegister); break;
                case 3: sellProduct(gums, cashRegister); break;
                case 4: sellProduct(cookies, cashRegister); break;
                default: System.out.println("Invalid Selection");
            }
            showSelection();
            choice = Integer.parseInt(keyboard.readLine());
        }
    }
    public static void showSelection(){
        System.out.println("*** Welcome to Shelly's Candy Shop ***");
        System.out.println("1 for Candy"); 
        System.out.println("2 for Chips");
        System.out.println("3 for Gum");
        System.out.println("4 for Cookies");
        System.out.println("9 to exit");
    }
    public static void sellProduct(Dispenser product, CashRegister cRegister)throws IOException{
        int amount, amount2;
        if(product.getCount() > 0){
            System.out.println("Please deposit "+product.getProductCost()+" cents");
            amount = Integer.parseInt(keyboard.readLine());
            
            if(amount < product.getProductCost()){
                System.out.println("Please deposit another "+(product.getProductCost() - amount)+" cents");
                amount2 = Integer.parseInt(keyboard.readLine());
                amount += amount2;
            }
            
            if(amount >= product.getProductCost()){
                cRegister.acceptAmount(amount);
                product.makeSale();
                System.out.println("Collect your item at the bottom and enjoy.");
            }else{
                System.out.println("The amount is not enough. Collect what you deposited.");
            }
            
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        }else{
            System.out.println("Sorry, this item is sold out.");
        }
    }
}
