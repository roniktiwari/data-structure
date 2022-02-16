package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Duplicate {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        checkDublicate(str);

    }

    private static void checkDublicate(String str) {
        // suppose we have a string (a+((b*c+d))+f)
        // we can see the there is pair of duplicate brackets which are not needed
        // we will create a stack of characters and keep on pushing the elements on by one
        // we will pop only when we see any closing brackets

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ']' || ch == '}' || ch == ')') {

                if (ch == ']') {
                    if (st.peek() == '[') {
                        System.out.println("Duplicasy in the expression");
                        return;
                    } else {
                        while (st.size() > 0 && st.peek() != '[') {
                            st.pop();
                        }
                        st.pop();
                    }

                } else if (ch == '}') {
                    if (st.peek() == '{') {
                        System.out.println("Duplicasy in the expression");
                        return;
                    } else {
                        while (st.size() > 0 && st.peek() != '{') {
                            st.pop();
                        }
                        st.pop();
                    }
                } else {
                    if (st.peek() == '(') {
                        System.out.println("Duplicasy in the expression");
                        return;
                    } else {
                        while (st.size() > 0 && st.peek() != '(') {
                            st.pop();
                        }
                        st.pop();
                    }
                }

            } else {
                st.push(ch);
            }

        }
        System.out.println("No Dublicasy in the system");
    }
}
