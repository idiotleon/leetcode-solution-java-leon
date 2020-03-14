/**
 * https://leetcode.com/problems/combination-sum-ii/
 */

package main.java.lcidiot.lc0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans, new ArrayList<Integer>(), candidates, target, 0);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, 
                     List<Integer> intermediate, 
                     int[] nums, 
                     int target, 
                     int index){
        if(target < 0) return;
        
        if(target == 0){
            ans.add(new ArrayList<Integer>(intermediate));
            return;
        }
        
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue;
            intermediate.add(nums[i]);
            dfs(ans, intermediate, nums, target - nums[i], i + 1);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}