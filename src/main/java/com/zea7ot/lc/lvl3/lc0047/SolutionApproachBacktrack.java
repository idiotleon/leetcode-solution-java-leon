/**
 * https://leetcode.com/problems/permutations-ii/
 */
package com.zea7ot.lc.lvl3.lc0047;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SolutionApproachBacktrack{
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;
        
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return ans;
    }
    
    private void backtrack(List<List<Integer>> ans, 
                     List<Integer> intermediate, 
                     int[] nums, 
                     boolean[] visited){
        if(intermediate.size() == nums.length){
            ans.add(new ArrayList<Integer>(intermediate));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            intermediate.add(nums[i]);
            backtrack(ans, intermediate, nums, visited);
            visited[i] = false;
            intermediate.remove(intermediate.size() - 1);
        }
    }
}