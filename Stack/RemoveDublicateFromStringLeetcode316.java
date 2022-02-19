package Stack;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;

public class RemoveDublicateFromStringLeetcode316 {



   // Suppose we are having below particular string
   // "cbadcefcbca " --->
   // lexicographical order

   //  Suppose every character in the string represent  employee of a startup
   //  and we want to create a board committee out of these Employees
   //  but the thing is board committee should have one and only one employee of each department
   //  and order should be maintained if possible
   //  So every employee will apply to be part f board committee
   // So before applying , they need  to check is there vacancy available from there department
   // for example if board already have SOFTWARE DEVELOPER/ they don't include another software
   // developer into the team


   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);
      String str = kb.next();
      String committeeMembers  = getCommitteeMembers(str);
      System.out.println(committeeMembers);
   }

   private static String getCommitteeMembers(String employees) {

    // First i need to create a black board where employee can check for vacancy
    // so that they can apply for board member if vacancy is available

      boolean  [] blackBoard = new boolean[26];

      Stack<Character> committee = new Stack<>();
      for(int i = 0 ; i<employees.length() ; i++)
      {
         char employee = employees.charAt(i);
         // first employee need to check the black board before applying to borad commitee memeber
         if(blackBoard[employee-'a']==false)
         {
            // if it is true that means he can apply
            if(committee.size()>0)
            {
               while(committee.size()>0 && committee.peek()>employee)
               {
                 boolean flag = doWeHaveOther(committee.peek(),employees,i);
                 if(flag==true)
                 {
                   char emp = committee.pop();
                   blackBoard[emp-'a'] = false;
                 }
                 else
                 {
                     break;
                 }
               }
            }
             committee.push(employee);
             blackBoard[employee-'a']=true;

         }
      }

      String commiteeMembers = "";
      while(committee.size()>0)
      {
        commiteeMembers = committee.pop()+commiteeMembers;
      }
      return commiteeMembers;

   }

   private static boolean doWeHaveOther(Character employee, String employees,int index) {

    for(int i = index+1 ; i < employees.length() ; i++)
    {
       if(employees.charAt(i)==employee)
       {
          return true;
       }
    }
    return false;
   }
}
