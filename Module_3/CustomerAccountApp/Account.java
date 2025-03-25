package Module_3.CustomerAccountApp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    private double balance;

    // Default constructor with initial balance
    public Account() {
        this.balance = 200.00;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amt) {
        balance += amt;
    }

    // Withdraw method
    public void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
        } else {
            System.out.println("  Error: Insufficient funds.");
        }
    }

    // Display menu method
    public void displayMenu() {
        System.out.println("\n  Account Menu");
        System.out.println("  Enter <D/d> for deposit");
        System.out.println("  Enter <W/w> for withdraw");
        System.out.println("  Enter <B/b> for balance");
        System.out.print("  Enter option>: ");
    }

    // Method to return transaction date
    public String getTransactionDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        return formatter.format(new Date());
    }
}
