package Recursion;

import java.util.Scanner;

public class FloodFill {

    public static void main(String [] args ){

          Scanner kb = new Scanner(System.in);
          int n = kb.nextInt();
          int m = kb.nextInt();
          System.out.println("Enter the "+n*m+"numbers");
          int [] [] arr = new int [n][m];
          for(int i=0 ; i<n ; i++){
              for(int j = 0 ; j<m ; j++){
                  arr[i][j]= kb.nextInt();
              }
          }

        for(int i=0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        boolean [][] visited = new boolean[n][m];
        printMazePaths(0,0,n-1,m-1,arr,visited,"");

    }


    private static void printMazePaths(int sr,int sc,int dr,int dc,int [][] arr,boolean [][] visited,String path) {

           if(sr<0 || sc <0 || sr>dr || sc>dc || arr[sr][sc]==1 || visited[sr][sc]==true) {
               return;
           }
           if(sr==dr && sc==dc){
               System.out.println(path);
               return;
           }
            visited[sr][sc]=true;
            printMazePaths(sr-1,sc,dr,dc,arr,visited,path+"t");
            printMazePaths(sr,sc-1,dr,dc,arr,visited,path+"l");
            printMazePaths(sr+1,sc,dr,dc,arr,visited,path+"d");
            printMazePaths(sr,sc+1,dr,dc,arr,visited,path+"r");
            visited[sr][sc]=false;

    }


}
