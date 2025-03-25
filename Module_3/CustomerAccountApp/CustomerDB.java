package Module_3.CustomerAccountApp;

public class CustomerDB {
    // Static method to get a customer based on ID
    public static Customer getCustomer(int id) {
        if (id == 1007) {
            return new Customer("Jennifer Patterson", "8422 Grover Ave.", "Bellevue", "68123");
        } else if (id == 1008) {
            return new Customer("Michael Adams", "1200 Pine St.", "Seattle", "98101");
        } else if (id == 1009) {
            return new Customer("Sarah Johnson", "402 Maple Ave.", "Omaha", "68102");
        } else {
            return new Customer(); // Return a default customer if ID is invalid
        }
    }
}
