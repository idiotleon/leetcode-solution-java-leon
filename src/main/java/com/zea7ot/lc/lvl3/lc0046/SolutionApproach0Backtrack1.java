/**
 * https://leetcode.com/problems/permutations/
 * 
 * Time Complexity:     O(N!)
 * Space Complexity:    O()
 * 
 * References:
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 */
package com.zea7ot.lc.lvl3.lc0046;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;
        
        backtrack(new ArrayList<Integer>(), nums, ans);
        return ans;
    }
    
    private void backtrack(List<Integer> intermediate, 
                           int[] nums, 
                           List<List<Integer>> ans){
        final int N = nums.length;
        if(intermediate.size() == N){
            ans.add(new ArrayList<Integer>(intermediate));
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(intermediate.contains(nums[i])) continue;
            intermediate.add(nums[i]);
            backtrack(intermediate, nums, ans);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}