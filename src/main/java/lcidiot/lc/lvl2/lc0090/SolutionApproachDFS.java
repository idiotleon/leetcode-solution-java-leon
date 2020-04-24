/**
 * https://leetcode.com/problems/subsets-ii/
 */
package main.java.lcidiot.lc.lvl2.lc0090;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDFS {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;
        
        Arrays.sort(nums);
        dfs(ans, new ArrayList<Integer>(), nums, 0);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, 
                     List<Integer> intermediate, 
                     int[] nums, 
                     int startPos){
        ans.add(new ArrayList<Integer>(intermediate));
        
        for(int i = startPos; i < nums.length; i++){
            if(i > startPos && nums[i] == nums[i - 1]) continue;
            
            intermediate.add(nums[i]);
            dfs(ans, intermediate, nums, i + 1);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}