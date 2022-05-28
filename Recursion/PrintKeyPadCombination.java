package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintKeyPadCombination {

    public static void main(String[] args) {
       //                    1  ,  2  , 3  , 4  ,  5  ,   6 ,  7  , 8  ,   9
        String [] arr =  { "abc","def","ghi","jkl","mnop","qrs","tuv","wxyz","?!"};
        List<String> allKeyCombination = getAllThekeyCombination(arr,"567");
        System.out.println(allKeyCombination);
    }

    private static List<String> getAllThekeyCombination(String [] arr ,String keyCombination) {

        if(keyCombination.length()==1){
            List<String> xList = new ArrayList<>();
            int key = keyCombination.charAt(0)-'0';
            String fkey = arr[key-1];
            for(char x : fkey.toCharArray()){
                xList.add(""+x);
            }
            return xList ;
        }

        int front = keyCombination.charAt(0) - '0';
        String subStr = keyCombination.substring(1);
        List<String> subKeyComb = getAllThekeyCombination(arr,subStr);
        String fstr = arr[front-1];
        List<String>  res  =  new ArrayList<>();
        for(char ch : fstr.toCharArray()){
            for(String x : subKeyComb){
                res.add(ch+x) ;
            }
        }
        return  res ;
    }


}
