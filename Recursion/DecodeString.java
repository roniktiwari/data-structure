package Recursion;

public class DecodeString {

    static int count = 0 ;
    public static void main(String[] args) {
        char [] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        noOfDecodedString("06","", arr);
        System.out.println(count);
    }

    private static void noOfDecodedString(String s, String ans, char[] arr) {

        if(s.length()==0){
            count++ ;
            return;
        }

        for(int i = 0 ; i < s.length() ; i++ ) {
            int idx = Integer.parseInt( s.substring(0,i+1));
            if(idx-1<0 || idx-1>25){
                break;
            }
            char ch  = arr[idx-1];
            String rest = s.substring(i+1);
            noOfDecodedString(rest,ans+ch, arr) ;
        }
    }
}
