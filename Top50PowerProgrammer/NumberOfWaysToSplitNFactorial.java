package Top50PowerProgrammer;

import java.util.HashSet;
import java.util.Set;

public class NumberOfWaysToSplitNFactorial {

    public static void main(String[] args) {
        System.out.println(splitNFactorial(5));
    }

    private static int splitNFactorial(int num ) {
         // calculate factorial of the number
         int factorial = fac(num);
         // find prime factor of factorial
         int p = getPrimeFactors(factorial);

         return (int)Math.pow(2,p-1);
    }

    private static int getPrimeFactors(int num) {
        Set<Integer> st = new HashSet<>();
        int i = 2 ;
        while(num!=1){
            if(num%i==0){
                st.add(i);
                num=num/i ;
            } else{
                i++;
            }
        }

        return st.size();
    }

    private static int fac(int num) {
        if(num==0){
            return  1 ;
        }
       return  fac(num-1)*num ;
    }
}
