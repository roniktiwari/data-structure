package DynamicProgramming;

public class MinimumCostPath {

    public static void main(String[] args) {
        int[][] maze = {{2,6,4,7},{3,1,5,3},{1,3,4,6},{2,2,3,0}};
        int [][] dp = new int[4][4];
        int minimumCost = getMeTheMinimumCost(0, 0, 3, 3, maze,dp);
        System.out.println(minimumCost);
    }

    private static int getMeTheMinimumCost(int sr, int sc, int dr, int dc, int[][] maze,int dp[][]) {

        if (sr == dr && sc == dc) {
            return maze[sr][sc];
        }
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        if(dp[sr][sc]!=0){
            return dp[sr][sc];
        }
        if (sc < dc) {
            min1 = getMeTheMinimumCost(sr, sc + 1, dr, dc, maze,dp);
        }
        if (sr < dr) {
            min2 = getMeTheMinimumCost(sr + 1, sc, dr, dc, maze,dp);
        }

        int netCost = Math.min(min1, min2) + maze[sr][sc];
        dp[sr][sc]=netCost;
        return netCost;
    }


}
