package Recursion;

public class PrintKeyPadSubsequence {

    public static void main(String[] args) {
      //                     1    2      3     4    5      6      7     8     9
        String [] arr =  { "abc","def","ghi","jkl","mno","pqr","stu","wxyz","?!"};
        printKeyPadSubSequence(arr,"567","");
    }

    private static void printKeyPadSubSequence(String [] arr , String number , String ans ) {

         if(number.length()==0){
             System.out.println(ans);
             return;
         }

          int ch = number.charAt(0)-'0';
          String substr = number.substring(1);
          for(char  x : arr[ch-1].toCharArray()) {
              printKeyPadSubSequence(arr, substr, ans +x);
          }

    }


}
