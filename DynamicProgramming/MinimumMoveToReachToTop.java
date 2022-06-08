package DynamicProgramming;

public class MinimumMoveToReachToTop {

    public static void main(String[] args) {
        int stairs = 5 ;
        int [] jumps = {2,3,1,2,3} ;
        int moves  = getTheMinimumMoveToReachTopStair(stairs,jumps);
        System.out.println(moves);
    }

    private static int getTheMinimumMoveToReachTopStair(int stairs, int[] jumps) {

        int [] minimumMoves  = new int [stairs+1] ;
        minimumMoves[minimumMoves.length-1] = 0 ;
        for(int i = minimumMoves.length-2;i>=0 ; i--){
            int minumum = Integer.MAX_VALUE ;
            for(int j = 1 ; j<=jumps[i] && i+j<=stairs; j++){
                minumum = Math.min(minumum,minimumMoves[i+j]);
            }
            minimumMoves[i]=minumum+1;
        }
        return minimumMoves[0];
    }
}
