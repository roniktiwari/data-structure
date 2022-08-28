package Top50PowerProgrammer;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {

    public static void main(String [] args){
        int arr [] = {1 ,2  ,3 } ;
        List<List<Integer>> sslist = getMeTheSubSequences(arr,0);
        System.out.println(sslist);
    }

    private static List<List<Integer>> getMeTheSubSequences(int[] arr, int n) {

        if(n==arr.length-1){
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            List<Integer> lst =  new ArrayList<>();
            lst.add(arr[n]);
            base.add(lst);
            return base;
        }
        List<List<Integer>> ssList = getMeTheSubSequences(arr, n + 1);
        List<List<Integer>> resulted = new ArrayList<>();
        for (List<Integer> x : ssList) {
            resulted.add(x);
        }
        for (List<Integer> x : ssList) {
             ArrayList<Integer> nw = new ArrayList<>();
             nw.addAll(x);
             nw.add(0,arr[n]);
             resulted.add(nw);
        }
        return resulted ;
    }
}
