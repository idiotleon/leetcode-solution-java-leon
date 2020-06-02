/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/longest-increasing-subsequence/discuss/74825/Short-Java-solution-using-DP-O(n-log-n)
 * 
 * Similar Problems
 *  2   0674    https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 *  3   1048    https://leetcode.com/problems/longest-string-chain/
 *  4   0128    https://leetcode.com/problems/longest-consecutive-sequence/
 *  4   0368    https://leetcode.com/problems/largest-divisible-subset/
 *  4   0646    https://leetcode.com/problems/maximum-length-of-pair-chain/
 *  4   0673    https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 *  4   0740    https://leetcode.com/problems/delete-and-earn/
 *  5   0354    https://leetcode.com/problems/russian-doll-envelopes/
 */
package com.polyg7ot.lc.lvl3.lc0300;

import java.util.Arrays;

public class SolutionApproach1DPWithBinarySearch {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        final int L = nums.length;
        int[] dp = new int[L];
        
        int len = 0;
        for(int num : nums){
            int i = Arrays.binarySearch(dp, 0, len, num);
            if(i < 0) i = -(i + 1);
            dp[i] = num;
            if(i == len) len++;
        }
        
        return len;
    }
}