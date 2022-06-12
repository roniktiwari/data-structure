package Top50PowerProgrammer;

public class LargestCoprimeDivisorSecondApproach {

    public static void main(String[] args) {

        System.out.println(coPrime(30,12));

    }

    private static int coPrime(int x , int y ) {

         // we need to find the largest co prime
        // first find gcd of (30,12)
        int gcd = gcd(30,12);
        int temp = 30/gcd ;
        return  temp ;

    }

    private static int gcd(int a, int b) {

        if(b==0){
            return a ;
        }else{
            return  gcd(b,a%b);
        }
    }

}
