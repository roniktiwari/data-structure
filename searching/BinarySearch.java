package searching;

public class BinarySearch {

    public static void main(String[] args) {
        // suppose we have one sorted array [3,6,9,15,17,19,45]
        // we want to find the index of 6 in this array

        int [] arr = {3,6,9,15,17,19,45} ;
        int idx = getMeTheIndex(arr,19);
        System.out.println(idx);
    }

    private static int getMeTheIndex(int[] arr, int num) {
        // using binary search using recursion
        // int idx = usingRecursionBinarySearch(arr,0,arr.length-1,num);
           int idx = usingLoopsBinarySearch(arr,num);
           return idx ;
    }

    private static int usingLoopsBinarySearch(int [] arr,int num) {
        int s = 0 ;
        int e = arr.length-1;
        while(s<e){
            int mid = (s+e)/2 ;
            if(arr[mid]==num){
                return mid;
            }
            else if(num<arr[mid]) {
                e=mid-1;
            }else{
              s=mid+1;
            }
        }
        return -1;
    }

    private static int usingRecursionBinarySearch(int [] arr,int s, int  e, int num) {

        if(s>=e){
            return -1;
        }
        int mid = (s+e)/2 ; // (0+6)/2=3
        if(arr[mid]==num){
            return mid ;
        }
        else if(num<arr[mid]){
            return usingRecursionBinarySearch(arr,s,mid,num);
        }
        else{
           return usingRecursionBinarySearch(arr,mid+1,e,num) ;
        }
    }


}
