package Top50PowerProgrammer;

public class CommonPrefix {

    public static void main(String[] args) {
        String arr[] = {"geeksforgeeks", "geeks", "geek", "geezer"};
        int len = Integer.MAX_VALUE;
        String min_len = "";
        for (String str : arr) {
            if (str.length() < len) {
                len = str.length();
                min_len = str;
            }
        }

        int j = 0 ;
        String common_prefix = "";
        boolean breaked = false;
        for(char ch : min_len.toCharArray()){
            for(int i = 0 ; i<arr.length ; i++) {
                if (arr[i].charAt(j)!=ch) {
                    breaked = true ;
                    break;
                }
            }
            if(breaked){
                break;
            }
            common_prefix+=ch ;
            j++;
        }
        System.out.println(common_prefix);
    }
}
