package Stack;

import java.util.Stack;

public class IsValidBalancedBracketString {

    public static void main(String[] args) {
        System.out.println(isValid("([{({}{})]])")); // [{}]
    }
    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i<s.length() ; i++)
        {
            char ch= s.charAt(i);
            if(ch=='{' || ch=='(' || ch=='[') // if it is opening then directly push
            {
                st.push(ch);
            }
            else
            {
                if(ch==')')
                {
                    if(st.peek()=='(')
                    {
                        st.pop();
                    }
                    else
                        return false;
                }
                else if(ch==']')
                {
                    if(st.peek()=='[')
                    {
                        st.pop();
                    }
                    else
                        return false;
                }
                else
                {
                    if(st.peek()=='{')
                    {
                        st.pop();
                    }
                    else
                        return false;
                }
            }
        }
        return true;
    }
}
