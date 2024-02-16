// ex 5 e

public class MyOwnAutoShop {
    public static void main(String[] args) {
        Sedan s = new Sedan(120, 50000, "Yellow", 30);
        Ford f1 = new Ford(160, 60000, "Red", 2022, 2000);
        Ford f2 = new Ford(160, 55000, "Blue", 2020, 3000);
        Car c = new Car(60, 30000, "Pink");

        System.out.println("Sedan Sale Price: " + s.getSalePrice());
        System.out.println("Ford1 Sale Price: " + f1.getSalePrice());
        System.out.println("Ford2 Sale Price: " + f2.getSalePrice());
        System.out.println("Car Sale Price: " + c.getSalePrice());
    }
}
