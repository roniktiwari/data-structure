package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class MinimumDenomination {

    //   { 1 , 2 , 5 , 10 , 20 , 50 , 100 , 200 ,500 , 2000 }
    public static void main(String [] args ){
         int num = 4437 ;
         int [] arr = { 1 , 2 , 5 , 10 , 20 , 50 , 100 , 200 ,500 , 2000 } ;
        // int count  = findMinimumNotes(arr,num,arr.length-1);
        // System.out.println(count);
        List<Integer> theNotes = getTheNotes(arr, num, arr.length - 1);
        System.out.println(theNotes);
    }


    public static List<Integer> getTheNotes(int [] arr , int num , int last ){

        if(num==0){
            return new ArrayList<Integer>() ;
        }
        int idx = -1 ;
        for(int i = last ; i>=0 ; i--) {
            if (arr[i] <= num) {
                idx = i;
                break;
            }
        }
        List<Integer> subLst  = getTheNotes(arr, num%arr[idx],idx) ;
        for(int i = num/arr[idx] ; i>0 ; i--){
            subLst.add(arr[idx]) ;
        }
        return subLst ;
    }

    private static int findMinimumNotes(int[] arr, int num , int last ) {

        // f(4437) ----> when we pass 4437 to this function it will return minimum counts of notes
        // f(437)---> it will return me minimum count
        if(num==0){
            return 0 ;
        }
        int idx = -1;
        for(int i = last ; i>=0 ; i--){
            if(arr[i]<=num){
                idx=i ;
                break ;
            }
        }
        int count = num/arr[idx]+ findMinimumNotes(arr,num%arr[idx],idx);

        return count ;
    }
}
