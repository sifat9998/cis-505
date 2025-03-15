package Module_1.FanApp;

public class Fan {
    // Constants for fan speed
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Private instance variables
    private int speed;
    private boolean isOn;
    private double radius;
    private String color;

    // No-argument constructor (default values)
    public Fan() {
        this.speed = STOPPED;
        this.isOn = false;
        this.radius = 6.0;
        this.color = "white";
    }

    // Argument constructor
    public Fan(int speed, boolean isOn, double radius, String color) {
        this.speed = speed;
        this.isOn = isOn;
        this.radius = radius;
        this.color = color;
    }

    // Accessor (getter) methods
    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return isOn;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    // Mutator (setter) methods
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Override toString method
    @Override
    public String toString() {
        if (isOn) {
            return String.format("The fan speed is set to %d with a color of %s and a radius of %.1f", speed, color, radius);
        } else {
            return String.format("The fan is %s with a radius of %.1f and the fan is off", color, radius);
        }
    }
}
