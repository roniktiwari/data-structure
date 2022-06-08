package DynamicProgramming;

public class GoldMineCollection {

    public static void main(String[] args) {
        int [][] goldMine = {{1,2,100},{2,3,5},{5,10,4}};
        int coins = getMeTheMaxCoins(goldMine);
        System.out.println(coins);
    }

    private static int getMeTheMaxCoins(int[][] goldMine) {

       int [][] dp = new int [goldMine.length][goldMine[0].length];
       int max = Integer.MIN_VALUE ;
       for(int row = 0 ; row < goldMine[0].length ; row++) {
           max=Math.max(max,getTheMaxCoinFromThisPoint(row, 0, goldMine[0].length - 1, goldMine, dp));
       }
       return max;
    }

    private static int getTheMaxCoinFromThisPoint(int sr, int sc, int destCol,int [][] goldMine,int [][] dp ) {

        if( sr<0 || sr>=goldMine.length || sc>destCol ){
         return 0 ;
        }
        if(dp[sr][sc]!=0){
            return dp[sr][sc];
        }
        int maxFromRoute1 = getTheMaxCoinFromThisPoint(sr-1,sc+1,destCol,goldMine,dp);
        int maxFromRoute2=  getTheMaxCoinFromThisPoint(sr,sc+1,destCol,goldMine,dp);
        int maxFromRoute3 = getTheMaxCoinFromThisPoint(sr+1,sc+1,destCol,goldMine,dp);

        int totalCoins = Math.max(Math.max(maxFromRoute1,maxFromRoute2),maxFromRoute3) + goldMine[sr][sc] ;
        dp[sr][sc]= totalCoins;
        return totalCoins;
    }

}
