package Recursion;

public class FirstOccuranceInArray {


    public static  void main(String [] args ) {
        int [] arr = { 10,20,30,40,50,20,80,90};
        int idx  =  getTheFirstOccurrenceIndex(arr , 20 , 0);
        System.out.println(idx);
    }

    private static int getTheFirstOccurrenceIndex(int[] arr, int number , int idx  ) {

        if(arr.length==idx){
            return -1 ;
        }

        if(arr[idx]==number){
            return  idx ;
        }
        int foisa = getTheFirstOccurrenceIndex(arr,number,idx+1);
        return foisa ;
    }

}
