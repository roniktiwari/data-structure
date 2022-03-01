package Stack;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Stack;

public class SlidingWindow {

    public static void main(String[] args) {

        int [] arr =  {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6} ;
        // We need to find the largest in each window
        int k  =  4 ;  // The size of window is four
        int [] ans  = getTheSlidingWindowArray(arr , k , arr.length );
        for(int x : ans )
        {
            System.out.println(x+" ");
        }
    }

    private static int[] getTheSlidingWindowArray(int[] arr, int k, int length) {

        int nextGreaterElementToRight [] = getNextGreaterElementToRight(arr);

        int ans  []   = new int [length-k+1];
        for(int i = 0 ; i <= length-k ; i++)
        {
            int j = i ;
            while(j<i+k && nextGreaterElementToRight[j]<i+k)
            {
               j= nextGreaterElementToRight[j];
            }
            ans[i]=arr[j];
        }
        return  ans ;
    }

    private static int[] getNextGreaterElementToRight(int[] arr) {
        java.util.Stack<Integer> st = new Stack<>();
        int [] res = new int [arr.length];
        res[res.length-1]=Integer.MAX_VALUE;
        st.push(arr.length-1);

        for(int i = arr.length-2 ; i>=0 ; i--)
        {
            int n = arr[i];
            while (st.size()>0 && arr[st.peek()]<=n)
            {
                st.pop();
            }
            if(st.size()>0) {
                res[i]=st.peek();
            }else {
                res[i]= Integer.MAX_VALUE;
            }
            st.push(i);
        }
        return  res;
    }


}
