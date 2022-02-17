package Stack;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MergeOverLapping {

    public static void main(String[] args) {
        // In this question we need to merge the overlapping intervals

        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the number lapping intervals ");
        int n = kb.nextInt();
        int [][] arr = new int [n][2];
        for(int i = 0 ; i<arr.length ; i++)
        {
            arr[i][0] = kb.nextInt();
            arr[i][1]=  kb.nextInt();
        }
        // Suppose we are having below intervals
            /*  14  18
                3   9
                5   12   // over lapp wo karenge jo agal bagal rahenge
                22  28
                13  27
                24  26
            */
       // 1. sort the based on the 1 value of the interval

        Arrays.sort(arr,(e1,e2)->e1[0]-e2[0]);

       // 2. After sorting the intervals we need to check the overlapping intervals and merge them and print

        Stack<int [] > st = new Stack<>();
        st.push(arr[0]);
        for(int i = 1; i < arr.length ;i++)
        {
            if(st.peek()[1]>arr[i][0])
            {
                // if it is overlapping the merge
                st.peek()[1]=Math.max(st.peek()[1],arr[i][1]);
            }
            else
            {
                // If merge process stops , the pop the interval and print the push the new one
                int [] a = st.pop();
                System.out.println(a[0]+" "+a[1]);
                st.push(arr[i]);
            }
        }
        System.out.println(st.peek()[0]+" "+st.peek()[1]);
    }
}
