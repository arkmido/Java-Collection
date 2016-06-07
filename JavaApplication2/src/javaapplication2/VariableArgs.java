package javaapplication2;
public class VariableArgs {
    public static void main(String args[]){
        System.out.printf("Average: %d\n", average(100,100,100));
    }
    static int average(int...numbers){
        int total = 0;
        for(int i : numbers)
            total+=i;
        
        return total/numbers.length;
    }
}
