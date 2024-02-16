import java.util.Scanner;

public class Lab1_ex1_mad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introdu un nr.: ");
        int nr = scanner.nextInt();

        if (nr >= 0) 
        {
            System.out.println("Nr. e pozitiv.");
        }
        else 
        {
            System.out.println("Nr. e negativ.");
        }

        scanner.close();
    }
}
