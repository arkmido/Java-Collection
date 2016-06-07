/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatestprograms1;

/**
 *
 * @author L3000n100
 * Implementing Runnable interface to create multithreaded program
 */
public class ThreadingTest implements Runnable{
    private Thread th1;
    private String threadName;
    
    ThreadingTest(String name){
        threadName = name;
        System.out.println("Creating "+threadName);
    }
    
    @Override
    public void run() {
        System.out.println("Running "+threadName);
        try{
            for(int i = 4; i > 0; i--){
                System.out.println("Thread: "+threadName+", "+i);
                Thread.sleep(50);
            }
        }catch(InterruptedException e){
            System.out.println("Thread "+threadName+" interrupted");
        }
        System.out.println("Thread" +threadName+" exiting");
    }
    
    public void start(){
        System.out.println("Starting "+threadName);
        if(th1 == null){
            th1 = new Thread(this, threadName);
            th1.start();
        }
    }
}
class MainThread{
    public static void main(String args[]){
        ThreadingTest t1 = new ThreadingTest("Thread1");
        t1.start();
        ThreadingTest t2 = new ThreadingTest("Thread2");
        t2.start();
    }
}
