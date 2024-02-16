// ex 5 d

public class Sedan extends Car {
    private int length;

    public Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    @Override
    public double getSalePrice() {
        if (length > 20) {
            return super.getSalePrice() * 0.95; 
            // discount = 5%
        } else {
            return super.getSalePrice() * 0.9; 
            // discount = 10% 
        }
    }
}
