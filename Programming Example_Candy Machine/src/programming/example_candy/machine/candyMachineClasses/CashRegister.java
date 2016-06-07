package programming.example_candy.machine.candyMachineClasses;

public class CashRegister {
    private int cashOnHand;
    
    public CashRegister(int cashIn){
        cashOnHand = cashIn >= 0 ? cashIn : 500;
    }
    public CashRegister(){
        cashOnHand = 500;
    }
    public void acceptAmount(int amountIn){
        cashOnHand = cashOnHand + amountIn;
    }
    public int currentBalance(){
        return cashOnHand;
    }
}
