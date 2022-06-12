package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;



public class TargetSumSubset {

    public static void main(String[] args) {
        int [] arr = {4,2,7,1,3};
        List<Integer> subSetList = new ArrayList<>();
        printArrSubset(arr,0, subSetList,0,10);
    }

    private static void printArrSubset(int[] arr, int idx, List<Integer> subSetList, int sum, int total) {

        if(idx==arr.length){
            System.out.println(subSetList);
            return;
        }
        subSetList.add(arr[idx]);
        printArrSubset(arr,idx+1,subSetList,sum+arr[idx],total);
        subSetList.remove(subSetList.size()-1);
        printArrSubset(arr,idx+1,subSetList,sum,total);
    }
}
