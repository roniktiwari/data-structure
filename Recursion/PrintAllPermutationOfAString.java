package Recursion;

public class PrintAllPermutationOfAString {

    public static void main(String[] args) {

        printAllThePermutation("abc","");
    }

    private static void printAllThePermutation(String str , String permutation) {


        if(str.length()==0) {
            System.out.println(permutation);
            return;
        }
        for(int i = 0 ; i<str.length();i++){
            char ch = str.charAt(i);
            String substr = str.substring(0,i)+str.substring(i+1,str.length());
            printAllThePermutation(substr,permutation+ch);
        }
    }

}
