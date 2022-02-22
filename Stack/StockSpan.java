package Stack;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] arr = new int [n];
        for(int i = 0 ; i<arr.length ; i++) {
            arr[i] = kb.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        st.push(0);  // Instead of pushing value , we can push index , create value out of it
        int [] spanInterval = new int[arr.length];
        spanInterval[0]=1;
        for(int i = 1 ; i< arr.length ; i++)
        {
            int num = arr[i];
            while(st.size()>0 && arr[st.peek()]<=num)
            {
                st.pop();
            }
            if(st.size()==0)
            {
                spanInterval[i]=i+1;
            }
            else {
                spanInterval[i] = i - st.peek();
            }
            st.push(i);
        }
        for(int x : spanInterval)
            System.out.println(x);
    }
}
