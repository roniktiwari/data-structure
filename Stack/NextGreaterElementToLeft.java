package Stack;


import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToLeft {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] arr = new int [n];
        for(int i = 0 ; i<arr.length ; i++) {
            arr[i] = kb.nextInt();
        }
        // suppose we are having few people in a line
        // every person is looking for other who is  having greater height(value) in the left

        int [] correspondingMatchArray = new int [arr.length];
        correspondingMatchArray[0]=-1;
        Stack<Integer> st = new Stack<Integer>();
        st.push(arr[0]);
        for(int i = 1 ; i <arr.length ; i++)
        {
            int person  = arr[i];
            while(st.size()>0 && st.peek()<=person)
            {
                // keep on popping
                st.pop();
            }
            if(st.size()==0) {
                correspondingMatchArray[i]=-1;
            }else {
                correspondingMatchArray[i]=st.peek();
            }
            st.push(person);
        }

        for(int x : correspondingMatchArray)
        {
            System.out.println(x);
        }
    }




}
