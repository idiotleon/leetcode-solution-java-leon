/**
 * https://leetcode.com/problems/combination-sum-ii/
 * 
 * Time Complexity:     O(N ^ target) in the worst case
 * Space Complexity:    O(target) in the worst case
 * 
 * References:
 *  https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)/435867
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 */
package com.zea7ot.lc.lvl3.lc0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(candidates == null || candidates.length == 0 || target < 1) return ans;
        
        Arrays.sort(candidates);
        final int N = candidates.length;
        boolean[] used = new boolean[N];
        
        backtrack(new ArrayList<Integer>(), target, 0, used, candidates, ans);
        return ans;
    }
    
    private void backtrack(List<Integer> intermediate, 
                           int target, 
                           int startIdx, 
                           boolean[] used,
                           int[] candidates, 
                           List<List<Integer>> res){
        if(target < 0) return;
        
        if(target == 0){
            res.add(new ArrayList<Integer>(intermediate));
            return;
        }
        
        // if the candidates array is sorted, "target >= candidates[i]" is used to prune further DFS
        for(int i = startIdx; i < candidates.length && target >= candidates[i]; i++){
            if(used[i] || (i > startIdx && !used[i - 1] && candidates[i - 1] == candidates[i])) continue;
            used[i] = true;
            intermediate.add(candidates[i]);
            backtrack(intermediate, target - candidates[i], i, used, candidates, res);
            used[i] = false;
            intermediate.remove(intermediate.size() - 1);
        }
    }
}