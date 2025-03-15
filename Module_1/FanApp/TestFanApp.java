package Module_1.FanApp;
public class TestFanApp {
    public static void main(String[] args) {
        // Create a fan using the no-argument constructor (default values)
        Fan defaultFan = new Fan();

        // Create a fan using the argument constructor
        Fan customFan = new Fan(Fan.MEDIUM, true, 8.0, "Blue");

        // Display both fan objects using the toString() method
        System.out.println(defaultFan.toString());
        System.out.println(customFan.toString());
    }
}
