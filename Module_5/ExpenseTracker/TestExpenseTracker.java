import java.io.*;
import java.util.*;

public class TestExpenseTracker {
    public static String menu() {
        return "\nWelcome to the Expense Tracker\n\nMENU OPTIONS\n  1. View Transactions\n  2. Add Transactions\n  3. View Expense\n\nPlease choose an option: ";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cont = "y";

        while (cont.equalsIgnoreCase("y")) {
            int input = ValidatorIO.getInt(sc, menu());

            if (input == 1) {
                try {
                    ArrayList<Transaction> transactions = TransactionIO.findAll();
                    System.out.println("\nMONTHLY EXPENSES");
                    for (Transaction t : transactions) {
                        System.out.println(t.toString() + "\n");
                    }
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (input == 2) {
                ArrayList<Transaction> transactions = new ArrayList<>();
                String addMore = "y";

                while (addMore.equalsIgnoreCase("y")) {
                    String description = ValidatorIO.getString(sc, "\n  Enter the description: ");
                    double amount = ValidatorIO.getDouble(sc, "  Enter the amount: ");
                    Transaction transaction = new Transaction(description, amount);
                    transactions.add(transaction);

                    addMore = ValidatorIO.getString(sc, "\n  Add another transaction? (y/n): ");
                }

                try {
                    TransactionIO.bulkInsert(transactions);
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (input == 3) {
                try {
                    ArrayList<Transaction> transactions = TransactionIO.findAll();
                    double total = 0;
                    for (Transaction t : transactions) {
                        total += t.getAmount();
                    }
                    System.out.printf("\nYour total monthly expense is $%,.2f\n", total);
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            cont = ValidatorIO.getString(sc, "\nContinue? (y/n): ");
        }

        System.out.println("\nProgram terminated by the user...");
        sc.close();
    }
}
