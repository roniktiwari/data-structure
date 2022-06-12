package Top50PowerProgrammer;

public class CountPrimes {

    public static void main(String[] args) {

        int count = countPrimes(90);
        System.out.println(count);
    }
    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] primes = new boolean[n];
        primes[0] = true;
        primes[1] = true;
        int x = (int) Math.sqrt(n);
        for (int i = 2; i <= x; i++) {
            if (primes[i] == false) {
                // if primes[i] is a prime then its multiples cannnot be a prime
                for (int j = i * i; j < n; j += i) {
                    primes[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == false) {
                count++;
            }
        }
        return count;

    }
}
