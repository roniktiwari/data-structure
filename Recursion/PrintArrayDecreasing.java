package Recursion;

public class PrintArrayDecreasing {

    public static  void main(String [] args ) {
        int [] arr = { 10,20,30,40,50};
        printDecreasing(arr,0);
    }

    private static void printDecreasing(int[] arr, int idx) {

        //
        //  Expectation : when we pass it ( arr , 0 ) -->
        // it will print all the element from last idx to 0th index

        if(idx== arr.length) {
            return;
        }
        printDecreasing(arr,idx+1);
        System.out.println(arr[idx]);
    }
}
