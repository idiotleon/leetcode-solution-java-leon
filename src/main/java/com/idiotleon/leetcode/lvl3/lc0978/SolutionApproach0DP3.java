/**
 * https://leetcode.com/problems/longest-turbulent-subarray/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/longest-turbulent-subarray/discuss/222511/DP-Thinking-Process-(Java)
 */
package com.idiotleon.leetcode.lvl3.lc0978;

public class SolutionApproach0DP3 {
    public int maxTurbulenceSize(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int maxLen = 0;
        int[][] dp = new int[N][2];
        
        for(int i = 1; i < N; i++){
            if(nums[i - 1] < nums[i]){
                dp[i][0] = dp[i - 1][1] + 1;
                maxLen = Math.max(maxLen, dp[i][0]);
            }else if(nums[i - 1] > nums[i]){
                dp[i][1] = dp[i - 1][0] + 1;
                maxLen = Math.max(maxLen, dp[i][1]);
            }
        }
        
        return maxLen + 1;
    }
}