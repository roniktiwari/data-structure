package Stack;

import java.util.Stack;

public class ConvertPrefixToInfixThenPostFix {

    public static void main(String[] args) {
        // The objective of this question is to convert
        // this string two "-+2/*6483"  to "((2+((6*4)/8))-3)"
        String str = covertToInfixExpression("-+2/*6483");
        System.out.println(str);
        String postfix = convertIntoPostFix(str);
        System.out.println(postfix);
    }

    private static String convertIntoPostFix(String str) {

        // suppose we have ((2-((6*4)/8))-3) this expression and we want to convert
        // it into postfix expression
           Stack<String> operandStack =  new Stack<>();
           Stack<Character> operatorStack = new Stack<>();
           for(int i= 0 ; i<str.length() ; i++)
           {
            char ch = str.charAt(i);
                if(ch=='(')
                {
                    operatorStack.push(ch);
                }
                else if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
                {
                    // when we enter in this loop ,we need to check
                    // Do we have any  operator with greater or equal precedence into the stack
                    // if yes then perform operation then push
                    while(operatorStack.size()>0 && operatorStack.peek()!='('&& precedence(operatorStack.peek())>=precedence(ch))
                    {
                        performOperation(operandStack,operatorStack);
                    }
                    operatorStack.push(ch);
                }
                else if(ch==')')
                {
                    while(operatorStack.size()>0 && operatorStack.peek()!='(')
                    {
                        performOperation(operandStack,operatorStack);
                    }
                    operatorStack.pop();
                }
                else
                {
                    operandStack.push(ch+"");
                }
           }
           return operandStack.peek();
    }

    private static int precedence(Character operator) {

        if(operator=='+' || operator=='-')
        {
            return 1;
        }
        else
        {
            return  2 ;
        }
    }

    private static void performOperation(Stack<String> operandStack, Stack<Character> operatorStack) {

      String num2= operandStack.pop();
      String num1=operandStack.pop();
      char ch = operatorStack.pop();

      operandStack.push(num1+""+num2+ch);
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
