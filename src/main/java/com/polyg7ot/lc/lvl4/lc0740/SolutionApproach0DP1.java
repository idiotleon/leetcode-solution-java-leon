/**
 * https://leetcode.com/problems/delete-and-earn/
 * 
 * Time Complexity:     O(N + R) + O(R) ~ O(N + R)
 *  N, the Number of elements in the input array
 *  R, the Range of the value of each integer element, which, in this case, is 10001,
 *      and can be optimized to the max value in the array, at an extra cost of O(N)
 * 
 * Space Complexity:    O(N + R)
 * 
 * References:
 *  https://leetcode.com/problems/delete-and-earn/discuss/109889/Java-Easy-DP-Solution/111623
 *  https://www.youtube.com/watch?v=YzZd-bsMthk
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-740-delete-and-earn/
 */
package com.polyg7ot.lc.lvl4.lc0740;

public class SolutionApproach0DP1 {
    public int deleteAndEarn(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;

        final int N = 10001;
        int[] sum = new int[N];
        for(int num : nums){
            sum[num] += num;
        }
        
        int[] dp = new int[N];
        dp[1] = sum[1];
        for(int i = 2; i < N; ++i){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }
        
        return dp[N - 1];
    }
}