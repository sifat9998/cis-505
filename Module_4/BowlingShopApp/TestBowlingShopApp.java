import java.util.Scanner;

public class TestBowlingShopApp {
    public static void displayMenu() {
        System.out.println("\n  MENU OPTIONS");
        System.out.println("    1. <b> Bowling Balls");
        System.out.println("    2. <a> Bowling Bags");
        System.out.println("    3. <s> Bowling Shoes");
        System.out.println("    4. <x> To exit");
        System.out.print("  Please choose an option: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("  Welcome to the Bowling Shop");

        do {
            displayMenu();
            choice = scanner.nextLine().toLowerCase();

            if (choice.equals("b") || choice.equals("a") || choice.equals("s")) {
                GenericQueue<Product> products = ProductDB.getProducts(choice);
                System.out.println("\n  --Product Listing--");

                while (products.size() > 0) {
                    Product p = products.dequeue();
                    System.out.println(p.toString() + "\n");
                }
            } else if (!choice.equals("x")) {
                System.out.println("\n  Invalid option\n");
            }
        } while (!choice.equals("x"));

        System.out.println("\n  End of line...");
        scanner.close();
    }
}
