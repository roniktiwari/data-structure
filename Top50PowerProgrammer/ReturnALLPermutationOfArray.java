package Top50PowerProgrammer;

import java.util.ArrayList;
import java.util.List;

public class ReturnALLPermutationOfArray {

    public static void main(String[] args) {
        int [] arr = {1,2,3} ;
        permute(arr);
    }

        public static  List<List<Integer>> permute(int[] nums) {
            // we need to return list of all the permutations
            List<List<Integer>> result  = new ArrayList<>();
            List<Integer> ans = new ArrayList<>();
            populateAllThePermutation(nums,ans,result);
            return result ;
        }
        public static void populateAllThePermutation(int[] nums, List<Integer> ans , List<List<Integer>> result ){

            if(ans.size()==nums.length){
                List<Integer> newList  = new ArrayList<>();
                newList.addAll(ans);
                result.add(newList);
                return;
            }

            for(int i = 0 ; i<nums.length ; i++){
                if(ans.contains(nums[i])){
                    continue ;
                }
                ans.add(nums[i]);
                populateAllThePermutation(nums,ans,result);
                ans.remove(ans.size()-1);
            }

        }

}
