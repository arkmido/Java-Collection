
package javaapplication2;

import java.util.Scanner;
public class GetInput {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        float x, y, result=0;
        
        System.out.print("Data 1: ");
        x = input.nextFloat();
        
        System.out.print("Data 2: ");
        y = input.nextFloat();
        
        System.out.print("[+, -, *, /] : ");
        char op = input.next().charAt(0);
        
        switch(op){
            case '+': result = x+y; break;
            case '-': result = x-y; break;
            case '*': result = x*y; break;
            case '/': result = x/y; break;
            default: System.out.println("Invalid input"); break;
        }
        
        System.out.println(x+" "+op+" "+y+" = "+result);
    }
}
