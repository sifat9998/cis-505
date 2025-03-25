package Module_3.CustomerAccountApp;

import java.util.Scanner;

public class TestCustomerAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("  Welcome to the Customer Account App");

        // Prompt for customer ID
        System.out.print("\n  Enter a customer ID:\n  ex: 1007, 1008, 1009>: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Get customer details
        Customer customer = CustomerDB.getCustomer(customerId);
        Account account = new Account();

        do {
            account.displayMenu();
            String option = scanner.nextLine().trim().toLowerCase();

            switch (option) {
                case "d":
                    System.out.print("\n  Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    account.deposit(depositAmount);
                    break;

                case "w":
                    System.out.print("\n  Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    account.withdraw(withdrawAmount);
                    break;

                case "b":
                    System.out.printf("\n  Account balance: $%,.2f\n", account.getBalance());
                    break;

                default:
                    System.out.println("\n  Error: Invalid option");
                    break;
            }

            // Ask if the user wants to continue
            System.out.print("\n  Continue? (y/n): ");
            choice = scanner.nextLine().trim().toLowerCase();

        } while (choice.equals("y"));

        // Display customer details
        System.out.println(customer.toString());
        System.out.printf("\n  Balance as of %s is $%,.2f\n", account.getTransactionDate(), account.getBalance());
        System.out.println("\n  End of line...");

        scanner.close();
    }
}
