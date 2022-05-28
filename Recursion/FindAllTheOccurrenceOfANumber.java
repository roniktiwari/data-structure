package Recursion;

import java.util.ArrayList;
import java.util.List;

public class FindAllTheOccurrenceOfANumber {
    public static void main(String[] args) {

        int [] arr = { 10,20,30,40,50,20,80,90};
        int [] idxList  =  getAllOccurrenceOfNumber(arr , 20 , 0 , 0);
        System.out.println(idxList);
    }

    public static int [] getAllOccurrenceOfNumber(int[] arr, int number, int idx, int count){

        if(arr.length==idx){
            return new int [count];
        }

          if(arr[idx]==number){
             int [] idxList =getAllOccurrenceOfNumber(arr,number,idx+1,count+1);
             idxList[count]=idx ;
             return idxList ;
          }else{
             int [] idxArr =  getAllOccurrenceOfNumber(arr,number,idx+1,count);
             return  idxArr ;
          }


    }


}
