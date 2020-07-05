/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N ^ 2)
 * 
 * dp[i][j] represents the longest fibonacci sequence ending with `nums[i]` and `nums[j]`
 * dp[i][j] = (dp[j - i][i] + 1) or 2
 * 
 * References:
 *  https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/discuss/165330/Java-beat-98-DP-%2B-2Sum
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
package com.zea7ot.lc.lvl3.lc0873;

public class SolutionApproach0DP2Dimen {
    public int lenLongestFibSubseq(int[] nums) {
        final int N = nums.length;
        int max = 0;
        int[][] dp = new int[N][N];
        for(int i = 2; i < N; i++){
            int lo = 0, hi = i - 1;
            while(lo < hi){
                int sum = nums[lo] + nums[hi];
                if(sum > nums[i]) hi--;
                else if(sum < nums[i]) lo++;
                else{
                    dp[hi][i] = dp[lo][hi] + 1;
                    max = Math.max(max, dp[hi][i]);
                    hi--;
                    lo++;
                }
            }
        }
        
        return max == 0 ? 0 : max + 2;
    }
}