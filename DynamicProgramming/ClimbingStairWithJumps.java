package DynamicProgramming;




    public class ClimbingStairWithJumps {
        public static void main(String[] args) {

           int stairs = 5 ;
           int [] jumps = {2,3,1,2,3} ;
           // this function will return me the number of paths to reach from 0 to 5 stair
           int ans = getTheNumberOfPath(0,stairs,jumps);
           System.out.println(ans);
        }

        private static int getTheNumberOfPath(int start, int stairs, int[] jumps) {

            int [] numberOfPaths = new int [stairs+1];
            numberOfPaths[numberOfPaths.length-1]=1;
            for( int i = numberOfPaths.length-2; i>=0 ; i--){
                int paths = 0 ;
                for(int j = 1 ; j<=jumps[i] && i+j<=stairs; j++ ){
                    paths += numberOfPaths[i+j];
                }
                numberOfPaths[i]=paths;
            }
            return numberOfPaths[0];
        }
    }
