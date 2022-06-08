package DynamicProgramming;

public class MinimumCostToReahUsingTabulation {


    public static void main(String[] args) {
        int[][] maze = {{2,6,4,7},{3,1,5,3},{1,3,4,6},{2,2,3,0}};
        int minimumCost = getMeTheMinimumCost(maze);
        System.out.println(minimumCost);
    }

    private static int getMeTheMinimumCost(int[][] maze) {

        int [][] dp = new int [maze.length][maze[0].length];
        int row = maze.length-1;
        int col = maze[0].length-1;

        for(int i= row ; i>=0 ; i--){
            for(int j = col ; j>=0 ;j--){
                int min = Integer.MAX_VALUE ;
                if(i==maze.length-1 && j==maze[0].length-1){
                    min =dp[i][j];
                }
                else if(i==maze.length-1){
                    min = Math.min(dp[i][j+1],Integer.MAX_VALUE)+maze[i][j];
                }
                else if (j==maze[0].length-1){
                    min=  Math.min(dp[i+1][j],Integer.MAX_VALUE)+maze[i][j];
                }else {
                    min = Math.min(dp[i][j + 1], dp[i + 1][j]) + maze[i][j];
                }
                dp[i][j]=min ;
            }
        }
        return dp[0][0];
    }
}
