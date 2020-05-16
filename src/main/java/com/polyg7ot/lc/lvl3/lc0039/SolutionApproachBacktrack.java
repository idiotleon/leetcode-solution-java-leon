/**
 * https://leetcode.com/problems/combination-sum/
 * 
 * Time Complexity: O(2 ^ target)
 *  O(2 ^ N), in the worst case
 * Space Complexity: 
 *  O(target)
 * 
 * References:
 *  https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)/323613
 */
package com.polyg7ot.lc.lvl3.lc0039;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachBacktrack{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if(candidates == null || candidates.length == 0) return ans;
        
        dfs(ans, new ArrayList<Integer>(), candidates, target, 0);
        
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, 
                     List<Integer> intermediate, 
                     int[] candidates, 
                     int target, 
                     int index){
        if(target < 0) return;
        
        if(target == 0){
            ans.add(new ArrayList<Integer>(intermediate));
            return;
        }
        
        for(int i = index; i < candidates.length; i++){
            intermediate.add(candidates[i]);
            dfs(ans, intermediate, candidates, target - candidates[i], i);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}