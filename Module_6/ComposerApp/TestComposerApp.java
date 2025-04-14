import java.util.List;
import java.util.Scanner;

public class TestComposerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemComposerDao dao = new MemComposerDao();
        int option;

        do {
            System.out.println("\nWelcome to the Composer App");
            System.out.println("\nMENU OPTIONS");
            System.out.println("  1. View Composers");
            System.out.println("  2. Find Composer");
            System.out.println("  3. Add Composer");
            System.out.println("  4. Exit");
            System.out.print("\nPlease choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            if (option == 1) {
                System.out.println("\n--DISPLAYING COMPOSERS--");
                List<Composer> composers = dao.findAll();
                for (Composer c : composers) {
                    System.out.println(c + "\n");
                }
            } else if (option == 2) {
                System.out.print("\nEnter an id: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // clear buffer
                Composer composer = dao.findBy(id);
                if (composer != null) {
                    System.out.println("\n--DISPLAYING COMPOSER--\n" + composer + "\n");
                } else {
                    System.out.println("\nComposer not found.\n");
                }
            } else if (option == 3) {
                System.out.print("\nEnter an id: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // clear buffer

                System.out.print("Enter a name: ");
                String name = scanner.nextLine();

                System.out.print("Enter a genre: ");
                String genre = scanner.nextLine();

                dao.insert(new Composer(id, name, genre));
            }

        } while (option != 4);

        System.out.println("\nProgram exited.");
        scanner.close();
    }
}
