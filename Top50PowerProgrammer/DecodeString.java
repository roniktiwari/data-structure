package Top50PowerProgrammer;

public class DecodeString {

    public static void main(String[] args) {

        int count  = numDecodings("231011");
    }

    public static int numDecodings(String str) {

        // First create an array name result having length equal string length

        // At each index we will store number of decoded string possible up to that index
        if(str.charAt(0)=='0'){
            return 0 ;
        }else if(str.length()==1){
            return 1 ;
        }
        int [] result = new int [str.length()] ;
        result[0] = 1 ;
        if(str.charAt(1)=='0'){
            result[1] = Integer.parseInt(str.substring(0,2))>26? 0 : 1 ;
        }else{
            result[1]= Integer.parseInt(str.substring(0,2))>26? 1 : 2 ;
        }

        for(int i = 2 ; i<str.length() ; i++){

            result[i] = str.charAt(i)=='0'? 0 : result[i-1];

            result[i] += str.charAt(i-1)=='0'? 0 : Integer.parseInt(str.substring(i-1,i+1))<=26 ? result[i-2] : 0 ;  ;
        }

        return result[str.length()-1];

    }

}
