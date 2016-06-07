package javaapplication2;

import java.util.Scanner;
public class JavaApplication2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, y, result = 0;
        String op;
        
        System.out.print("num1: ");
        x = sc.nextInt();
        
        do{
            System.out.print("Enter operator (+, -, *, /) : ");
            op = sc.next();
            if((op.equals("+")|| op.equals("-") || op.equals("*") || op.equals("/"))) break;
        }while(true);
        
        System.out.print("num2: ");
        y = sc.nextInt();
        
        switch(op){
            case "+": result = add(x,y); break;
            case "-": result = sub(x,y); break;
            case "*": result = mul(x,y); break;
            case "/": result = div(x,y); break;
            default: break;
        }
        System.out.println(x+" "+op+" "+y+" = "+result);
        /*
        if(op == '+')
            result = add(x,y);
        else if(op == '-')
            result = sub(x,y);
        else if(op == '*')
            result = mul(x,y);
        else if(op == '/')
            result = div(x,y);
        else
            System.out.println("Invalid operator");
        */   
    }
    
    static int add(int x, int y){
        return x+y;
    }
    
    static int sub(int x, int y){
        return x-y;
    }
    
    static int mul(int x, int y){
        return x*y;
    }
    
    static int div(int x, int y){
        return x/y;
    }
    
}
