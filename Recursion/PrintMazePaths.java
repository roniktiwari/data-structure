package Recursion;

public class PrintMazePaths {

    public static  void main(String [] args ){
        
        printMazePaths(1,1,2,2,"");

    }

    private static void printMazePaths(int sx, int sy, int dx, int dy,String path ) {

        if((sx==dx) && (sy==dy)){
            System.out.println(path);
            return;
        }
        if(sy<dy)
        printMazePaths(sx,sy+1,dx,dy,path+"h");
        if(sx<dx)
        printMazePaths(sx+1,sy,dx,dy,path+"v");
    }

}
