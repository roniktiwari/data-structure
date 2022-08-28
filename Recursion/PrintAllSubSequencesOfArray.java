package Recursion;

import java.util.ArrayList;

public class PrintAllSubSequencesOfArray {

    public static  void main(String [] args){

        int [] arr = {1,2,3} ;
        printAllSubSequences(arr,0,new ArrayList<>());
    }

    public static void printAllSubSequences(int [] arr,int idx , ArrayList sf){
        if(idx>= arr.length){
            System.out.println(sf);
            return;
        }
        int num = arr[idx];
        sf.add(num);
        printAllSubSequences(arr,idx+2,sf);
        sf.remove(sf.size()-1);
        printAllSubSequences(arr,idx+1,sf);
    }
}

