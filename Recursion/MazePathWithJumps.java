package Recursion;


import java.util.ArrayList;
import java.util.List;

public class MazePathWithJumps {

    public static void main(String[] args) {
        // suppose we have a maze ( 3*4 )
          List<String> gtp =  getThePaths(1,1,2,2);
          System.out.println(gtp);
    }

    private static List<String> getThePaths(int sx, int sy, int dx, int dy) {


        if((sx==dx ) && (sy==dy)) {
            ArrayList<String> stx = new ArrayList<>( );
            stx.add("");
            return stx ;
        }
        List<String> res = new ArrayList<>();
        for(int i = 1 ; i<=dy-sy ; i++) {
            List<String> paths = getThePaths(sx, sy + i, dx, dy);
            for(String p : paths){
                res.add("h"+i+p);
            }
        }
        for(int i = 1 ; i<=dx-sx ; i++) {
            List<String> paths = getThePaths(sx+i, sy, dx, dy);
            for(String p : paths){
                res.add("v"+i+p);
            }
        }

        for(int i = 1 ; i<=dx-sx && i<=dy-sy; i++) {
            List<String> paths = getThePaths(sx+i, sy+i, dx, dy);
            for(String p : paths){
                res.add("d"+i+p);
            }
        }

         return  res ;
    }


}
