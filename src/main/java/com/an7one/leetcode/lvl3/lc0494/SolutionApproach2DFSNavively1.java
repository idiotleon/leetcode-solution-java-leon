/**
 * https://leetcode.com/problems/target-sum/
 * 
 * Time Complexity:     O(2 ^ N)
 * Space Complexity:    O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/239358
 */
package com.an7one.leetcode.lvl3.lc0494;

public class SolutionApproach2DFSNavively1 {
    private int count;
    
    public int findTargetSumWays(int[] nums, int S) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        this.count = 0;
        dfs(0, 0, nums, S);
        return count;
    }
    
    private void dfs(int idx, int sum, int[] nums, int S){
        if(idx == nums.length){
            if(sum == S) count++;
        }else{
            dfs(idx + 1, sum + nums[idx], nums, S);
            dfs(idx + 1, sum - nums[idx], nums, S);
        }
    }
}