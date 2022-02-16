package Stack;

import java.util.Scanner;
import java.util.Stack;

public class EvaluateInfixExpression {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        int res = getResultOfInfixExpression(str);
        System.out.println("Result---->"+res);
    }

    private static int getResultOfInfixExpression(String str) {
        Stack<Integer> operandStack = new Stack<>();
        for(int i = str.length()-1 ; i>=0 ; i--)
        {  // character can be a mathematical operand or it can be a integer
           char ch = str.charAt(i);
           if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
           {
               performOperationAndPush(operandStack,ch);
           }
           else
           {
               // we enter into this else block when it is a integer
               operandStack.push(Character.getNumericValue(ch));
           }

        }
        return operandStack.peek();
    }

    private static void performOperationAndPush(Stack<Integer> operandStack, char ch) {

        int num1= operandStack.pop();
        int num2= operandStack.pop();
        if(ch=='*')
            operandStack.push(num1*num2);
        else if(ch=='/')
            operandStack.push(num1/num2);
        else if(ch=='-')
             operandStack.push(num1-num2);
        else
            operandStack.push(num1+num2);
    }

}
