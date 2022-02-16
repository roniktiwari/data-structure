package Stack;

import java.util.Stack;

public class ConvertPrefixToInfix {

    public static void main(String[] args) {
        // The objective of this question is to convert
        // this string two "-+2/*6483"  to "((2+((6*4)/8))-3)"
        String str = covertToInfixExpression("-+2/*6483");
        System.out.println(str);
    }

    private static String covertToInfixExpression(String str) {

        Stack<String> operandStack = new Stack<>();
        for(int i = str.length()-1 ; i>=0 ; i--)
        {  // character can be a mathematical operand or it can be a integer
            char ch = str.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
            {
                performOperationAndPush2(operandStack,ch);
            }
            else
            {
                // we enter into this else block when it is a integer
                operandStack.push(ch+"");
            }

        }
        return operandStack.peek();

    }

    private static void performOperationAndPush2(Stack<String> operandStack, char ch) {

        String num1= operandStack.pop();
        String num2= operandStack.pop();
        if(ch=='*')
            operandStack.push("("+ num1 + "*" +num2 + ")" );
        else if(ch=='/')
            operandStack.push("("+num1+"/"+num2+")");
        else if(ch=='-')
            operandStack.push("("+num1+"-"+num2+")");
        else
            operandStack.push("("+num1+"-"+num2+")");

    }
}
