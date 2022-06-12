package Top50PowerProgrammer;

import java.util.ArrayList;
import java.util.List;

public class PrintNextPermutation {

    public static void main(String[] args) {
        // suppose we have a number [ 6 , 4 , 3 , 2 ] ----> [ 1 , 6 , 2 , 3  ]
        // we need to find next  greater permutation
        int [] arr = { 6 , 4 , 3 , 2 };
        List<Integer> permute  = getMeTheNextPermutation(arr);
        System.out.println(permute);
    }

    private static List<Integer> getMeTheNextPermutation(int [] nums  ) {


        // first we find the pivot such that arr[pivot]< arr[pivot + 1]
        // initially assigned pivot to -1
        List<Integer> result = new ArrayList<>() ;
        int pivot = -1  ;
        for(int idx = nums.length-2 ; idx>=0 ; idx--){
            if(nums[idx]<nums[idx+1]){
                pivot = idx ;
                break ;
            }
        }
        if(pivot==-1){
            reverse(0,nums);
            for(int x : nums ){
                result.add(x);
            }
            return result ;
        }

        // now gain traverse from right and find element just greater then pivot
        int j = -1 ;
        for(int idx = nums.length-1 ; idx>=0 ; idx--){
            if(nums[idx]>nums[pivot]){
                j=idx ;
                break;
            }
        }
        // Do swapping swap( pivot , j )
        swap(pivot,j,nums) ;
        // now reverse the arr from pivot to end
        reverse(pivot+1,nums);
        return result;
     }

    private static void reverse(int pivot,int [] arr) {
        int j = arr.length-1 ;
        while(pivot< j){
              swap(pivot,j,arr);
              pivot++;
              j-- ;
        }
    }

    public static void swap(int i , int j , int arr []){

        arr[i] = arr[i]+arr[j];
        arr[j] = arr[i]-arr[j];
        arr[i] = arr[i]-arr[j];
    }

}
