// ex 5 a

public class Car {
    private int speed;
    private double regularPrice;
    private String color;

    // constructor
    public Car(int speed, double regularPrice, String color) {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    public double getSalePrice() {
        return regularPrice;
    }
}
