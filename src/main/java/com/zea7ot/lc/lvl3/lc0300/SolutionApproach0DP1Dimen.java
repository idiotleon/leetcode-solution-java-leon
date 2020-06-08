/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/longest-increasing-subsequence/discuss/74836/My-easy-to-understand-O(n2)-solution-using-DP-with-video-explanation/144619
 *  https://youtu.be/7DKFpWnaxLI
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-300-longest-increasing-subsequence/
 */
package com.zea7ot.lc.lvl3.lc0300;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen {
    public int lengthOfLIS(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        // Elements are length(s) of LISs ending with num(nums[i - 1])
        int[] dp = new int[N];
        // the default LIS of each element in nums(int[]) is 1, NOT 0
        // e.g. were they completely strictly decreasing in the worst case
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 1; i < N; i++){
            // either line26 or line30 works
            // dp[i] = 1
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}