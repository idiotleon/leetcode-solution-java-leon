/**
 * https://leetcode.com/problems/permutations/
 */
package com.null7ptr.lc.lvl3.lc0046;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachBacktrack {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;

        dfs(ans, new ArrayList<Integer>(), nums);
        
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, 
                     List<Integer> intermediate, 
                     int[] nums){
        if(intermediate.size() == nums.length){ 
            ans.add(new ArrayList<Integer>(intermediate));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(intermediate.contains(nums[i])) continue;
            intermediate.add(nums[i]);
            dfs(ans, intermediate, nums);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}