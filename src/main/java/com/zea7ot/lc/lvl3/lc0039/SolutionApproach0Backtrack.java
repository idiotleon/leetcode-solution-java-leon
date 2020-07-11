/**
 * https://leetcode.com/problems/combination-sum/
 * 
 * Time Complexity:     O(2 ^ target)
 *  O(2 ^ N), in the worst case
 * 
 * Space Complexity:    O(target)
 *  
 * 
 * References:
 *  https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)/323613
 *  https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 */
package com.zea7ot.lc.lvl3.lc0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0Backtrack{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(candidates == null || candidates.length == 0) return ans;
        
        // to help prune it a little bit
        Arrays.sort(candidates);
        backtrack(new ArrayList<Integer>(), target, 0, candidates, ans);
        return ans;
    }
    
    private void backtrack(List<Integer> intermediate, 
                           int target, 
                           int startPos, 
                           int[] candidates,
                           List<List<Integer>> ans){
        if(target < 0) return;
        
        if(target == 0){
            ans.add(new ArrayList<Integer>(intermediate));
            return;
        }
        
        // to prune a little bit
        for(int i = startPos; i < candidates.length && candidates[i] <= target; i++){
            intermediate.add(candidates[i]);
            backtrack(intermediate, target - candidates[i], i, candidates, ans);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}