/**
 * https://leetcode.com/problems/minimum-falling-path-sum-ii/
 * 
 * Time Complexity:     O(NR * (NC ^ 2))
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-falling-path-sum-ii/discuss/689243/Java-Simple-DP
 */
package com.zea7ot.leetcode.lvl4.lc1289;

public class SolutionApproach0DP2Dimen1 {
    public int minFallingPathSum(int[][] nums) {
        // sanity check
        if(nums == null || nums.length == 0 || nums[0].length == 0) return 0;
        
        final int NR = nums.length, NC = nums[0].length;
        int[][] dp = new int[NR][NC];
        int ans = Integer.MAX_VALUE;
        for(int row = 0; row < NR; row++){
            if(row == 0) dp[row] = nums[row];
            else for(int col = 0; col < NC; col++){
                dp[row][col] = Integer.MAX_VALUE;
                for(int k = 0; k < NC; k++){
                    if(col == k) continue;
                    dp[row][col] = Math.min(dp[row][col], nums[row][col] + dp[row - 1][k]);
                }
                if(row == NR - 1) ans = Math.min(ans, dp[row][col]);
            }
        }
        
        return ans;
    }
}