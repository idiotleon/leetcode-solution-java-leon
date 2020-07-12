/**
 * https://leetcode.com/problems/subsets/
 * 
 * Time Complexity:     O(2 ^ N) + O(N * lg(N)) ~ O(2 ^ N)
 * Space Complexity:    O()
 * 
 * References:
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 */
package com.zea7ot.lc.lvl2.lc0078;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;
        
        // sorting is for trimming duplicates
        Arrays.sort(nums);
        backtrack(new ArrayList<Integer>(), 0, nums, ans);
        return ans; 
    }
    
    private void backtrack(List<Integer> intermediate, 
                           int startPos, 
                           int[] nums,  
                           List<List<Integer>> ans){
        ans.add(new ArrayList<Integer>(intermediate));
        
        for(int i = startPos; i < nums.length; i++){
            intermediate.add(nums[i]);
            backtrack(intermediate, i + 1, nums, ans);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}