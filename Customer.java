public class Customer {
    private String name;
    private double balance;
    
    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    
    public String getName() {
        return name;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public boolean hasEnoughBalance(double amount) {
        return balance >= amount;
    }
    
    public void deductBalance(double amount) {
        if (hasEnoughBalance(amount)) {
            balance -= amount;
        }
    }
    
    public void addBalance(double amount) {
        balance += amount;
    }
}