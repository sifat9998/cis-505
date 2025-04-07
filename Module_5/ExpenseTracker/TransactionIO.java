import java.io.*;
import java.util.*;

public class TransactionIO {
    private static final String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);

    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output;

        if (file.exists()) {
            output = new PrintWriter(new FileOutputStream(file, true));
        } else {
            output = new PrintWriter(file);
        }

        for (Transaction t : transactions) {
            output.print(t.getDate() + " ");
            output.print(t.getDescription() + " ");
            output.println(t.getAmount());
        }

        output.close();
    }

    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String date = input.next();
            String description = input.next();
            double amount = input.nextDouble();
            Transaction t = new Transaction(description, amount);
            t.setDate(date);
            transactions.add(t);
        }

        input.close();
        return transactions;
    }
}
