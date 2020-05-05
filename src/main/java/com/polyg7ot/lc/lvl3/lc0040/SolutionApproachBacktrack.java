/**
 * https://leetcode.com/problems/combination-sum/
 * 
 * https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)/435867
 * Time Complexity: O(N ^ target) in the worst case
 * Space Complexity: O(target) in the worst case
 */
package com.polyg7ot.lc.lvl3.lc0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproachBacktrack {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(candidates == null || candidates.length == 0 || target < 1) return ans;
        
        // Since no duplicates is guaranteed, there is no need to sort candidates
        // However, sorting the candidates helps prune the DFS
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
        
        // if the candidates array is sorted, "target >= candidates[i]" is used to prune further DFS
        for(int i = startIdx; i < candidates.length && target >= candidates[i]; i++){
            intermediate.add(candidates[i]);
            backtrack(intermediate, target - candidates[i], i, candidates, res);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}