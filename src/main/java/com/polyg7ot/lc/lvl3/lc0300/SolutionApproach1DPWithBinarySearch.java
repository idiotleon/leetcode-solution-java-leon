/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * Time Complexity: O(N * lg(N))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/longest-increasing-subsequence/discuss/74825/Short-Java-solution-using-DP-O(n-log-n)
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