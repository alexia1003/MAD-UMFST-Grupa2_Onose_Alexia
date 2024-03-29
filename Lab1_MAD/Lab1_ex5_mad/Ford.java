// ex 5 c

public class Ford extends Car {
    private int year;
    private int manufacturerDiscount;

    // constructor
    public Ford(int speed, double regularPrice, String color, int year, int manufacturerDiscount) {
        super(speed, regularPrice, color);
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    @Override
    public double getSalePrice() {
        double salePrice = super.getSalePrice();
        return salePrice - manufacturerDiscount;
    }
}
