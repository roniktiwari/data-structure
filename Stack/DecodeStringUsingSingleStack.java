package Stack;

import java.util.Scanner;
import java.util.Stack;

public class DecodeStringUsingSingleStack {

    public static void main(String[] args)  {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        Stack<String> st = new Stack<>();
        for(char ch : str.toCharArray())
        {
            if(ch==']') {
                 String content = "";
                 while(st.size()>0 && !st.peek().equals("["))  {
                     content=st.pop()+content;
                 }
                 st.pop();
                 // Ab mujhe digit milengi
                 String number = "";
                 while(st.size()>0 && isInteger(st.peek()))
                 {
                     number = st.pop()+number;
                 }
                 performOperation(st,content,number);


            }
            else {
                st.push(ch+"");
            }
        }
        System.out.println((st.pop()));
    }

    private static void performOperation(Stack<String> st ,String content , String number) {

        int n = Integer.parseInt(number);
        String res = "";
        while (n > 0) {
            res = res + content;
            n--;
        }
        st.push(res);
    }

    private static boolean isInteger(String peek) {

        try {
            Integer.parseInt(peek);
        }
        catch (Exception ex )
        {
            return false ;
        }
        return true;
    }


}
