package Recursion;

import java.util.ArrayList;
import java.util.List;

public class TargetSumSubset {

    public static void main(String [] args ){

             int [] arr = {10,20,30,40,50,60};
             List<Integer> subSetList = new ArrayList<>();
             printArrSubset(arr,0, subSetList,0,60);
    }

    private static void printArrSubset(int[] arr, int start, List<Integer> subSetList, int sum,int n) {


         if(sum==n){
             System.out.println(subSetList);
             return;
         }
         if(arr.length==start || sum>n){
             return;
         }
         int num = arr[start];
         subSetList.add(num);
         printArrSubset(arr,start+1,subSetList,sum+num,n);
         subSetList.remove(subSetList.size()-1);
         printArrSubset(arr,start+1,subSetList,sum,n);

        }
}
