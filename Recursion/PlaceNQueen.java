package Recursion;

public class PlaceNQueen {

    public static void main(String[] args) {

        int [][] chess = new int [4][4];
        placeNqeen(chess,0,"");

    }

    private static void placeNqeen(int[][] chess, int row, String path) {

        if(row==chess.length){
            System.out.println(path);
            return;
        }
        for(int col = 0 ; col <chess[0].length ; col++){
            if(canBePlaceQueenHere(chess,row,col)) {
                chess[row][col] = 1;
                placeNqeen(chess, row + 1, path + row + "-" + col + ",");
                chess[row][col] = 0;
            }
        }
    }

    private static boolean canBePlaceQueenHere(int[][] chess, int row, int col) {

        for(int i = row -1 ; i>=0;i--){
            if(chess[i][col]==1){
                return  false ;
            }
        }

        for(int i = row -1 , j = col-1 ; i>=0 && j>=0 ; i--, j--){
            if(chess[i][j]==1){
                return  false ;
            }
        }
        for(int i = row -1 , j = col+1 ; i>=0 && j<chess.length; i--, j++){
            if(chess[i][j]==1){
                return  false ;
            }
        }
        return  true;
    }
}
