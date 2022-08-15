package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class Problem {
    public static void main(String[] args) {
        int [] arr = {99,32,64,81};
        Set<Integer> primeFactors = new HashSet<>();

        int i = 2 ;
        for(int x : arr){
            while(x>1){
                if(x%i==0){
                    primeFactors.add(i);
                    x=x/i;
                }else {
                    i++ ;
                }
            }
            System.out.println(x+"-------->"+primeFactors);
            i=2;
        }

    }

}
