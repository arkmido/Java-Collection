/*
 *      This program demonstrates the use of anonymous classes
 *      -anonymous classes follows the rules of inner classes.
 *      -anonymous classes can't be static.
 */
package Javaclassespractice;

public class AnonymousClass {
    public static void main(String args[]){
        ball b = new ball(){
            public void hit(){
                System.out.println("ball hit");
            }
        };
        b.hit();
    }
    interface ball{
        void hit();
    }
}
