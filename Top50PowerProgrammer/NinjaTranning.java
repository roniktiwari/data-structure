package Top50PowerProgrammer;

public class NinjaTranning {
   public static void main(String[] args) {

       int [][] arr =  {
                          { 1,2,5 } ,
                          { 3,1,1 },
                          { 3,3,3 }
                       };
       int maxpoints = getMeTheMaxPoints(arr,2,4);
       System.out.println(maxpoints);
    }
/*
    private static void   printMaxPoints(int[][] arr,int days ,int lastSelected,int total) {
            if(days==-1){
                if(total>max) max = total;
                return ;
            }

            for(int i = 0 ; i < arr[days].length ; i++){
                if(lastSelected==i) continue;
                int point = arr[days][i];
                printMaxPoints(arr,days-1,i,total+point);
            }
    }
  */

    public static int getMeTheMaxPoints(int [][] arr , int days , int lastSelected  ) {

            if(days==0){
                int maxi = 0 ;
                for(int i = 0 ; i<arr[days].length ; i++){
                    if(lastSelected!=i) maxi =Math.max(maxi,arr[days][i]) ;
                }
                return maxi ;
            }

            int max = Integer.MIN_VALUE ;
            for(int i = 0 ; i<arr[days].length ; i++){
                if(i==lastSelected) continue;
                int total = arr[days][i]+getMeTheMaxPoints(arr,days-1,i);
                max=Math.max(max,total);
            }
            return max ;
        }
}
