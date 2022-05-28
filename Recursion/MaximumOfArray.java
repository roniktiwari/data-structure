package Recursion;

public class MaximumOfArray {

    public static  void main(String [] args ) {
        int [] arr = { 10,20,30,40,50};
        int max =  printMaximumOfArray(arr,0);
        System.out.println(max);
    }

    private static int printMaximumOfArray(int[] arr, int idx) {
         if(arr.length-1==idx) {
             return  arr[idx];
         }
         int subMax = printMaximumOfArray(arr,idx+1);
         if(arr[idx]>subMax) {
             return arr[idx];
         }
         return subMax ;
    }


}
