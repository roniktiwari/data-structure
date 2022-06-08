package DynamicProgramming;

public class ClimbingStairsWithTabulation {

    public static void main(String[] args) {
        int [] dp = new int [6+1] ;
        int totalPath = getMeTheTotalPaths(0,6,dp);
        System.out.println(totalPath);
    }

    private static int getMeTheTotalPaths(int start , int stair , int [] dp ) {

         dp[dp.length-1]= 1;
         for(int i = dp.length-2 ; i >=0 ; i--){

             if(i==dp.length-2){
                 dp[i]=dp[i+1];
             }else if(i==dp.length-3){
                 dp[i]=dp[i+1]+dp[i+2];
             }else
               dp[i]= dp[i+1]+dp[i+2]+dp[i+3];
         }
         return dp[0];
    }
}
