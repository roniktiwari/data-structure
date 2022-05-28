package Recursion;

import java.util.ArrayList;
import java.util.List;

public class StairCasePath {

    public static void main(String[] args) {

        List<String> paths = getAllThePaths(7,0);
        System.out.println(paths);
    }

    private static List<String> getAllThePaths(int stair, int last) {
        // Expectation from this function is when we call this ( 7 , 0 )
        // it will return list of paths in steps to reach from 7th to 0th step

        // Faith : we will get the list for ( 6 , 0) , ( 5,0 ) ,( 4,0 )

        // we get on to the negative stair that means its now a valid path
        if(stair<0){
         List<String> pathList = new ArrayList<>();
         return pathList;
        }
        if(stair==0){
            List<String> pathList = new ArrayList<>();
            pathList.add("");
            return pathList ;
        }
        List<String> allThePaths1 = getAllThePaths(stair - 1, last);
        List<String> allThePaths2 = getAllThePaths(stair - 2, last);
        List<String> allThePaths3 = getAllThePaths(stair - 3, last);
        List<String> totalPaths =  new ArrayList<>();
        allThePaths1.stream().forEach((path)->{
            totalPaths.add("1"+path);
        });
        allThePaths2.stream().forEach((path)->{
            totalPaths.add("2"+path);
        });
        allThePaths3.stream().forEach((path)->{
            totalPaths.add("3"+path);
        });

        return totalPaths ;
    }
}
