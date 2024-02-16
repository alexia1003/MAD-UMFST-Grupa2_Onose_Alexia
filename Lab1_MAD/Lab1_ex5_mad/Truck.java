// ex 5 b

public class Truck extends Car {
    private int weight;

    // constructor
    public Truck(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    @Override
    public double getSalePrice() {
        if (weight > 2000) {
            return super.getSalePrice() * 0.9; 
            // discount = 10% 
        } else {
            return super.getSalePrice() * 0.8;
            // discount = 20% 
        }
    }
}
