package Top50PowerProgrammer;

import java.util.HashSet;
import java.util.Set;

public class LargestCoprimeDivisor {

    public static void main(String[] args) {
        System.out.println(cpFact(30, 12));
    }

    public static int cpFact(int A, int B) {

        // store all the factors of A and store in a list
        Set<Integer> set = new HashSet<>();
        int x = (int) Math.sqrt(A);
        for (int i = 1; i <= x; i++) {
            if (A % i == 0) {
                int fac1 = A / i;
                int fac2 = i;
                set.add(fac1);
                set.add(fac2);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : set) {
            if (GCD(num, B) == 1) {
                max = Math.max(max, num);
            }
        }
        return max;
    }

    public static int GCD(int x, int y) {

        int div = x;
        int divident = y;

        while (divident % div != 0) {
            int temp = div;
            div = divident % div;
            divident = temp;
        }
        return div;
    }

}
