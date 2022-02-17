package Stack;

import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the number ");
        int n =  kb.nextInt();
        int [][] arr = new int[n][n];
        for(int i = 0 ; i<n ; i++) {
            for(int j = 0 ; j<n ; j++)
            {   System.out.println("Enter the data ");
                arr[i][j]=kb.nextInt();
            }
        }

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i<arr.length ; i++)
        {
            st.push(i);
        }

        while(st.size()>1)
        {
            int candidate_1 = st.pop();
            int candidate_2 = st.pop();
            if(arr[candidate_1][candidate_2]==1)
            {
                st.push(candidate_2);
            }
            else
            {
                st.push(candidate_1);
            }
        }

        int potentialCandidate = st.peek();
        int i=0;
        for( i= 0 ; i<n ; i++)
        {
            if(i==potentialCandidate)
            {
                continue;
            }
            if(arr[i][potentialCandidate]!=1)
            {
                break;
            }
        }
        if(i==n)
        {
            System.out.println(potentialCandidate);
        }
        else {
            System.out.println("none");
        }
    }
}
