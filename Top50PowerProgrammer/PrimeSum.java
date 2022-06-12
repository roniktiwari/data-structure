package Top50PowerProgrammer;

import java.util.ArrayList;

public class PrimeSum {

        public static void main(String[] args) {
            System.out.println(primesum(6));
        }

        public static ArrayList<Integer> primesum(int A) {

            boolean[] compositeAndPrimes = new boolean[A];
            ArrayList<Integer> list = new ArrayList<>();
            // initially all the are false, that means all number are primes

            compositeAndPrimes[0] = true;
            compositeAndPrimes[1] = true;

            int x = (int) Math.sqrt(A);
            for (int i = 2; i <= x; i++) {
                if (compositeAndPrimes[i] == false)
                    // if it is true that means compositeAndPrimes[i] is prime {
                    for (int j = i * i; j < A; j = j + i) {
                        compositeAndPrimes[j] = true;
                    }
            }

            // after this loop we will have all false as prime and true are composite
            for (int i = 2; i < A; i++) {
                if (compositeAndPrimes[i] == false && compositeAndPrimes[A - i] == false) {
                    list.add(i);
                    list.add(A - i);
                    break;
                }

            }
            return list;
        }
    }