package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllTheSubSequenceOfAString {


    public static void main(String[] args) {
        //suppose we have a string "abc" and we want to print all its subsequence
      /*        - - -
                - - C,
                - B -,
                - B C,
                A - -,
                A - C,
                A B -
                A B C,
    */

        List<String> ssl = printAllSubsequences("abc");
        System.out.println(ssl);
    }

    private static List<String> printAllSubsequences(String abc) {
        // Expectation from the function : when we call this func("abc")
        // it will print all the above subsequences

        if(abc.length()==1){
            List<String> strList = new ArrayList<>();
            strList.add(abc);
            strList.add("");
            return strList ;
        }
        // Faith : func("bc",1) --> it will print all the
        List<String> xlist = new ArrayList<>();
        char front = abc.charAt(0);
        String str = abc.substring(1);
        List<String> arrList =  printAllSubsequences(str);
        for(String x : arrList) {
            xlist.add(front + x);
            xlist.add(x);
        }

        return  xlist ;
    }
}
