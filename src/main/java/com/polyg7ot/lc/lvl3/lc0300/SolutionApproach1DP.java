/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/longest-increasing-subsequence/discuss/74836/My-easy-to-understand-O(n2)-solution-using-DP-with-video-explanation/144619
 */
package com.polyg7ot.lc.lvl3.lc0300;

import java.util.Arrays;

public class SolutionApproach1DP {
    public int lengthOfLIS(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}