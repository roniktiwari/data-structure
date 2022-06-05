package DynamicProgramming;

public class Fibnoci {

    public static void main(String[] args) {

        int [] arr = new int [6+1];
        int myFibo = getMeTheFibnocciNumberMemoization(6,arr);
        System.out.println(myFibo);

    }


    private static int getMeTheFibnocciNumberMemoization(int n, int[] questionBank) {

        if (n == 0 || n == 1) {
            return n;
        }
        if (questionBank[n] != 0) {
            return questionBank[n];
        }
        int num1 = getMeTheFibnocciNumberMemoization(n-1, questionBank);
        int num2 = getMeTheFibnocciNumberMemoization(n-2, questionBank);

        questionBank[n] = num1 + num2;

        return num1 + num2;
    }


    private static int getMeTheFibnocciNumber(int n) {

        if(n==0 ||n==1){
            return  n;
        }
        int num1 = getMeTheFibnocciNumber(n-1);
        int num2 = getMeTheFibnocciNumber(n-2);
        return num1+num2 ;
    }
}
