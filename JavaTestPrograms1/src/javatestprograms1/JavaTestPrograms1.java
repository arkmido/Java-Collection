package javatestprograms1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaTestPrograms1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter an integer: ");
        int i = getInt();
        System.out.println("You entered " + i);
    }
    // this method will only execute if an exception occured
    
    public static int getInt(){
        while(true){
            try{
                return sc.nextInt();
            }catch(Exception e){
                sc.next();
                System.out.println("That's not a valid integer.\nPlease try again.");
            }
        }
    }
    
}
