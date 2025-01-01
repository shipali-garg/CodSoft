package task3;

public class BankATM implements ATM{
	private double balance;

    // Constructor
    public BankATM(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to check balance
    @Override
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    // Method to deposit money
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("You have successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("You have successfully withdrawn: $" + amount);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to transfer money
    @Override
    public void transfer(double amount, String recipientAccount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("You have successfully transferred: $" + amount + " to account: " + recipientAccount);
        } else if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }

}
