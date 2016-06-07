/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatestprograms1;

/**
 *
 * @author L3000n100
 */
import java.util.Random;
public class ThreadingTest3 implements Runnable{
    private String name;
    private int time;
    private Random r = new Random();
    ThreadingTest3(String x){
        System.out.println("Creating: "+x);
        name = x;
        time = r.nextInt(999);
    }
    @Override
    public void run() {
        try{
            System.out.println(name+" is sleeping for "+time+"ms");
            Thread.sleep(time);
            System.out.println(name+" is done");
        }catch(InterruptedException e){
            System.out.println(name+" is interrupted");
        }
    } 
}
class ThreadInvoker{
    public static void main(String args[]){
        Thread t1 = new Thread(new ThreadingTest3("thread-1"));
        Thread t2 = new Thread(new ThreadingTest3("thread-2"));
        Thread t3 = new Thread(new ThreadingTest3("thread-3"));
        Thread t4 = new Thread(new ThreadingTest3("thread-4"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
