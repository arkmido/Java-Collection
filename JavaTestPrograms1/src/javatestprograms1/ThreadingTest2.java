/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatestprograms1;

/**
 *
 * @author L3000n100
 * Extending Thread class
 */
public class ThreadingTest2 extends Thread{
    private Thread t;
    private String threadName;
    
    ThreadingTest2(String name){
        threadName = name;
        System.out.println("Creating: "+threadName);
    }
    @Override
    public void run(){
        System.out.println("Running "+threadName);
        try{
            for(int i = 4; i > 0; i--){
                System.out.println("Thread: "+threadName+", "+i);
                Thread.sleep(50);
            }
        }catch(InterruptedException e){
            System.out.println("Thread "+threadName+" interrupted");
        }
        System.out.println("Thread: "+ threadName+" exiting..");
    }
//    @Override
//    public void start(){
//        System.out.println("Starting: "+threadName);
//        if(t == null){
//            t = new Thread(this, threadName);
//            t.start();
//        }
//    }
}
class ThreadMain{
    public static void main(String args[]){
        ThreadingTest2 th1 = new ThreadingTest2("Thread-1");
        th1.start();
        ThreadingTest2 th2 = new ThreadingTest2("Thread-2");
        th2.start();
    }
}
