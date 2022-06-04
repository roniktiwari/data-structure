package Recursion;

public class PrintStairCasePaths {


    public static void main(String[] args) {
        printStairCasePaths(5,"");
    }

    private static void printStairCasePaths(int stair, String path) {

        if(stair<0){
            return;
        }
        if(stair==0){
            System.out.println(path);
            return ;
        }

        printStairCasePaths(stair-1,path+1);
        printStairCasePaths(stair-2,path+2);
        printStairCasePaths(stair-3,path+3);
    }
}
