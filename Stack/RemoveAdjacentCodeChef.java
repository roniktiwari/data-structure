package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveAdjacentCodeChef {

    // In this problem we need to reduce an Array by performing an operation
    // until all the element become same
    // OPERATION :- We can add two adjacent element at a time

    //  Suppose we are having an array like [ 3 , 6 ,1 , 4, 2 , 3 , 1 , 10 ]
    //  we want this array to be reduced such that all the element become same
    //  if in general , arr [a1 , a2 , a3 , a4 , a5 , a6 .......an ]
    //  In reduced form it will be like [ x1 , x2 , x3 , ...xm  ]
    //  where x1 x2 x3..xm ->>> is the sum of sub-array of arr
    //  x1=x2=x3=...=xm = X
    //  Conclusions: -
    //  the sum arr =  the resulting array sum
    //  S = X*m
    //  we can conclude the element in the final array will be the factor of S
    //  So for our case S = 30
    //  What are the factors of 30 - >>
    /*  Below are the possible solutions for element in the final array that is X
        but we will reject some numbers , WHY ? Because the final element cannot be less than the maximum in the array
        {
          1 * 30
          2 * 15
          3 * 10
          5 * 6
        }
         After rejecting  the range will like  { 10 , 15 , 30 }
         Now will check is 10 is possible in the final array for this we will take help of perfix sum
         { 3, 9 , 10 , 14 , 16 , 19 , 20 , 30 }
         if are able to find three factors of 10 , that means  yes 10 is possible
         and our answer will be (arr.length-3) = 5
    */

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        int [] arr = new int[num];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i<arr.length ; i++)
        {
            arr[i]=  kb.nextInt();
            max = Math.max(arr[i],max);
            sum+=arr[i];
        }
        if(sum==0)
        {
            int count = 0;
            for(int x : getPrefixArray(arr))
            {
                if(x==0)
                {
                    count++;
                }
            }
            System.out.println(arr.length - count);
            return;
        }
        if(arr.length==1)
        {
            System.out.println(0);
            return ;
        }
        int i = 0;
        for(; i<arr.length-1 ; i++)
        {
            if(arr[i]!=arr[i+1])
            {
                break;
            }
        }
        if(i==arr.length)
        {
            System.out.println(0);
            return ;
        }
        int res = getMinimumOperation(arr , sum , max );
        System.out.println(res);
    }
    private static int getMinimumOperation(int[] arr, int sum , int max ) {

        // first we need to find
        // what is the possible element in final array
        List<Integer> possibleValueOfX =  new ArrayList<>();
        for(int i = 1 ; i*i<=sum ; i++)
        {
            if(sum%i==0)
            {

                if( sum/i>=max  )
                {
                    possibleValueOfX.add(sum/i);
                }
            }
        }

        int[] prefixArray = getPrefixArray(arr);

        for(int i = possibleValueOfX.size()-1 ; i >=0 ;  i--)
        {
            int x = possibleValueOfX.get(i);
            int count = 0;
            for(int n : prefixArray)
            {
                if(n%x==0){
                    count++;
                }
            }
            if(count==sum/x)
            {
                return arr.length-sum/x;
            }
        }
        return arr.length-1;
    }

    private static int[] getPrefixArray(int[] arr) {
        int [] prefixArray = new int[arr.length];
        int prefixElement = 0 ;
        for(int i = 0; i < arr.length ; i++)
        {
            prefixElement+= arr[i];
            prefixArray[i]=prefixElement;
        }
        return prefixArray;
    }

}
