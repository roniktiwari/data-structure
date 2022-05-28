package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GetMazePaths {

    public static void main(String[] args) {
        List<String> allMazePaths = getAllMazePaths(1, 1, 2, 3);
        System.out.println(allMazePaths);
    }

    private static List<String> getAllMazePaths(int sx, int sy, int dx, int dy) {

        // Expectation : when we pass ( 1,1,4,5) .
        // it will return the list of path from (1,1) to (4,5) such as hhhhvvv etc.

        if((sx==dx) && (sy==dy)) {
            List<String> xList = new ArrayList<>();
            xList.add("");
            return xList;
        }
        List<String> totalPaths = new ArrayList<>();
        if(sy<dy) {
            List<String> allMazePath1 = getAllMazePaths(sx, sy + 1, dx, dy);
            allMazePath1.stream().forEach((path)->{
                totalPaths.add("h"+path);
            });
        }
        if(sx<dx) {
            List<String> allMazePath2 = getAllMazePaths(sx + 1, sy, dx, dy);
            allMazePath2.stream().forEach((path)->{
                totalPaths.add("v"+path);
            });
        }
        return totalPaths ;

    }

}
