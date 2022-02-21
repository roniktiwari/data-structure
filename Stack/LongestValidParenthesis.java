package Stack;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidParenthesis {

/*    In this question, we need to find the longest valid parenthesis string
*     Suppose we are having string like ")(()))((()))"
*     we need  find the valid longest parenthesis sub String
*
*    1. Yaddi mujhe closed parenthesis ')' k corresponding koi open bracket stack me nahi milta
*       to me manunga ki vaild parenthesis substring milna band ho gai .
*       Jo bhi valid parenthesis ki length ho wo check karnge max length se
*        yadi jada to max update kar denge;
*/
            public static void main(String[] args) {

                Scanner kb = new Scanner(System.in);
                String str = kb.next();
                int len  = getMaxValidParenthesisLength(str);
                System.out.println(len);
            }

            private static int getMaxValidParenthesisLength(String str) {
                Stack<Character> st = new Stack<>();
                Stack<Integer> problemIndexStack =  new Stack<>();
                problemIndexStack.push(-1);
                int len = 0 ;
                for(int i = 0 ; i< str.length() ; i++)
                {
                    char ch = str.charAt(i);
                    if(ch=='(') {
                         st.push(ch);
                         problemIndexStack.push(i);
                    } else {
                        if(st.size()>0)
                        {
                            st.pop();
                            problemIndexStack.pop();
                            len = Math.max(i-problemIndexStack.peek(),len);
                        }
                        else
                        {
                            problemIndexStack.push(i);
                        }

                    }

                }
                return len ;
            }

}
