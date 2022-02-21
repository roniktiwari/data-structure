package Stack;

import java.io.CharConversionException;
import java.util.Scanner;
import java.util.Stack;

public class SimplifiedPathFacebookProblem {


    /*
     Question : -  What this problem says ?
     In this question , we need to simplify a complex absolute path containing below characters
     1.   it can be a dot --> ' . '
     2.   it can be a forward slash ---> '/'
     3.   it can  be letters forming file name ---> 'abc' or 'sts'  or 'idea' etc

     suppose we have the below complex path such as
     " /.../../
     /abc///xyz/pqr/./.././ " and we need to simply this path
      after simplify we will we having " /.../abc/xyz"


      ALGO:-
      1. We have take care of only . and alphabets
      2. If we are able to find . or alphabet(A-Z or a-z) then
      3. we will start creating string
      4. After String creation , we will check few thing
      5. IS this string ..

     */





    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        String simplifiedPath = getSimplifiedPath(str);
        System.out.println(simplifiedPath);
    }

    private static String getSimplifiedPath(String str) {
        Stack<String> folderStack = new Stack<>();

        for(int i = 0 ; i < str.length() ; i++)
        {
            char ch =  str.charAt(i);
            if(ch=='.' || ( 'a'<=ch && ch<='z'))
            {
                String possibleString = getTheString(str,i);
                if(possibleString.equals("..") && folderStack.size()>0)
                {
                    folderStack.pop();
                }
                else if(possibleString.length()>2 || Character.isAlphabetic(possibleString.charAt(0)))
                {
                    folderStack.push(possibleString);
                }
                i+=possibleString.length()-1;
            }
        }
        String res = "";
        if(folderStack.size()==0)
        {
            return "/";
        }
        while(folderStack.size()>0)
        {
            res = "/"+folderStack.pop()+res;
        }
        return res;
    }

    private static String getTheString(String str, int index) {
        String resultant = "";
        for(int i = index ; i<str.length() ; i++)
        {
            if(str.charAt(i)!='/')
            {
                resultant+=str.charAt(i);
            }
            else
                break;
        }
        return resultant ;
    }

}
