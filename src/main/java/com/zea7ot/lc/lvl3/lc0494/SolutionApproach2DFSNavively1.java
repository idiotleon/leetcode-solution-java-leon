/**
 * https://leetcode.com/problems/target-sum/
 * 
 * Time Complexity:     O(2 ^ N)
 * Space Complexity:    O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/239358
 */
package com.zea7ot.lc.lvl3.lc0494;

public class SolutionApproach2DFSNavively1 {
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