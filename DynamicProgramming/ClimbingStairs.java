package DynamicProgramming;

public class ClimbingStairs {

    public static void main(String[] args) {
        int [] questionBank = new int [6+1];
        int paths = getNumberOfPath(6,questionBank);
        System.out.println(paths);
    }

    private static int getNumberOfPath(int num,int [] questionBank) {
        if(num==0){
            return 1 ;
        }
        if(num<0){
            return  0 ;
        }
        if(questionBank[num]!=0){
            return questionBank[num];
        }
        int x  = getNumberOfPath(num-1,questionBank);
        int y = getNumberOfPath(num-2,questionBank);
        int z = getNumberOfPath(num-3,questionBank);
        int total = x + y + z ;
        questionBank[num]=total;
        return total ;
    }



}
