package Stack;

import java.util.Scanner;
import java.util.Stack;

public class SimplifiedPathMoreOptimisedSolution {


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String unSimplifiedPath =  kb.next();
        String simplifiedPath = getTheSimplifiedPath(unSimplifiedPath);
        System.out.println(simplifiedPath);
    }

    private static String getTheSimplifiedPath(String unSimplifiedPath) {
        java.util.Stack<String> folderStack = new Stack<>();
        String [] possibleString = unSimplifiedPath.split("/");
        for(String str : possibleString)
        {
            if(str.isEmpty())
            {
                continue;
            }
            if(str.equals("..") && folderStack.size()>0)
            {
                folderStack.pop();
            }
            else if (!str.equals("..") && !str.equals("."))
            {
                folderStack.push(str);
            }
        }

        String resultant  ="";
        while(folderStack.size()>0)
        {
            resultant="/"+folderStack.pop()+resultant;
        }
        return  resultant.length()>0?resultant:"/";
    }

}
