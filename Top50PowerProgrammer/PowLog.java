package Top50PowerProgrammer;

public class PowLog {
    public static void main(String[] args) {
        System.out.println(myPow(2.00, -2));
    }

    public static double myPow(double x, int n) {

        if(n==0){
            return 1 ;
        }

        double subResult = myPow(x,n/2);
        double netResult = subResult * subResult ;
        if( n%2==1  || n%2== -1 ){
            if(n<0){

                netResult = netResult * (1/x) ;
            }else {
                netResult = netResult * x ;
            }
        }

        return netResult ;
    }
}