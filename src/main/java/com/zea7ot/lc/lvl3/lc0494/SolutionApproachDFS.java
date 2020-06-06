/**
 * https://leetcode.com/problems/target-sum/
 */
package com.zea7ot.lc.lvl3.lc0494;

public class SolutionApproachDFS {
    private int count;
    
    public int findTargetSumWays(int[] nums, int S) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        this.count = 0;
        dfs(nums, 0, 0, S);
        return count;
    }
    
    private void dfs(int[] nums, int i, int sum, int S){
        if(i == nums.length){
            if(sum == S){
                count++;
            }
        }else{
            dfs(nums, i + 1, sum + nums[i], S);
            dfs(nums, i + 1, sum - nums[i], S);
        }
    }
}