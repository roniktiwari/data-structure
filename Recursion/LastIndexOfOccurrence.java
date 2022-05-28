package Recursion;

public class LastIndexOfOccurrence {

    public static  void main(String [] args ) {
        int [] arr = { 10,20,30,40,50,20,80,90};
        int idx  =  getTheLastOccurrenceIndex(arr , 20 , 0);
        System.out.println(idx);
    }

    private static int getTheLastOccurrenceIndex(int[] arr, int number, int idx) {
        // Expectation :-  when we pass this getTheLastOccurrenceIndex( arr,20,0)
        // it will check from 0th index to arr.length and return last index of 20  -->7

        if(arr.length==idx){
            return -1 ;
        }

        int loi = getTheLastOccurrenceIndex(arr,number,idx+1);
        if(loi==-1){
            if(arr[idx]==number) {
                return idx ;
            }
        }
        return loi ;
    }


}
