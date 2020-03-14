/**
 * https://leetcode.com/problems/permutations/
 */

package main.java.lcidiot.lc0046;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<Integer>(), nums);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, 
                     List<Integer> intermediate, 
                     int[] nums){
        if(intermediate.size() == nums.length){ 
            ans.add(new ArrayList(intermediate));
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