public class Lab1_ex3_mad {
    
    public static boolean isPrime(int nr) {
        if (nr <= 1) 
        {
            return false;
        }
        for (int i = 2; i < nr; i++) 
        {
            if (nr % i == 0) 
            {
                return false;
            }
        }
        return true;
    }

    public static void gasireTwinPrime(int n) {
        for (int i = 2; i < n; i++) 
        {
            if (isPrime(i) && isPrime(i + 2)) 
            {
                System.out.println("(" + i + ", " + (i + 2) + ")");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Twin prime numbers less than 100:");
        gasireTwinPrime(100);
    }
}
