package javaapplication2;

import java.util.Scanner;
public class Test{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int x = 0;
        do{
            try{
                System.out.print("Num > 0: ");
                x = in.nextInt();
            }catch(Exception e){
                System.out.println(e);
                in.next();
            }
        }while(x <= 0);     
    }
}
