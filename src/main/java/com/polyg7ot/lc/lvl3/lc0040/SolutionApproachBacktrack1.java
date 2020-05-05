/**
 * https://leetcode.com/problems/combination-sum-ii/
 * 
 * https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)/435867
 * Time Complexity: O(N ^ target) in the worst case
 * Space Complexity: O(target) in the worst case
 */
package com.polyg7ot.lc.lvl3.lc0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproachBacktrack1{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>(); 
        // sanity check
        if(candidates == null || candidates.length == 0 || target < 1) return ans;
        
        Arrays.sort(candidates);
        
        backtrack(new ArrayList<Integer>(), target, 0, candidates, ans);
        
        return ans;
    }
    
    private void backtrack(List<Integer> intermediate, 
                           int target, 
                           int startIdx,
                           int[] candidates,
                           List<List<Integer>> res){
        if(target < 0) return;
        
        if(target == 0){
            res.add(new ArrayList<Integer>(intermediate));
            return;
        }
        
        for(int i = startIdx; i < candidates.length; i++){
            // to avoid repeatitively dealing with any duplicate candidate
            if(i != startIdx && candidates[i - 1] == candidates[i]) continue;
            intermediate.add(candidates[i]);
            backtrack(intermediate, target - candidates[i], i + 1, candidates, res);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}