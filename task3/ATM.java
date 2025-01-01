package task3;

public interface ATM {
	void checkBalance();
    void deposit(double amount);
    void withdraw(double amount);
    void transfer(double amount, String recipientAccount);
}
