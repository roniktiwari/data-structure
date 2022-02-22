package Stack;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToTheRight {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] arr = new int [n];
        for(int i = 0 ; i<arr.length ; i++) {
            arr[i] = kb.nextInt();
        }

        int [] correspondingMatchArray = new int [arr.length];
        correspondingMatchArray[correspondingMatchArray.length-1]=-1;
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-1]);
        for(int i = arr.length-2 ; i>=0 ;i--)
        {
            int person = arr[i];
            while(st.size()>0 && st.peek()<=person)
            {
                st.pop();
            }
            if(st.size()==0)
            {
                correspondingMatchArray[i]=-1;
            }else
            {
                correspondingMatchArray[i]=st.peek();
            }
            st.push(person);
        }
        for(int x : correspondingMatchArray)
            System.out.println(x);
    }

}
