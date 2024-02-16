import java.util.Scanner;

public class Lab1_ex2_mad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introdu nr. elem. in vector:");
        int n = scanner.nextInt();
        
        int[] array = new int[n];
        
        System.out.println("Introdu elem. din vector:");
        for (int i = 0; i < n; i++) 
        {
            array[i] = scanner.nextInt();
        }

        double sum = 0;
        for (int i = 0; i < n; i++) 
        {
            sum += array[i];
        }

        double average = sum / n;
        System.out.println("Valoare medie a elem. din vector e: " + average);

        scanner.close();
    }
}
