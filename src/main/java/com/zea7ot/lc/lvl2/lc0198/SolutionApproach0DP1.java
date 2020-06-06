/**
 * https://leetcode.com/problems/house-robber/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
package com.zea7ot.lc.lvl2.lc0198;

public class SolutionApproach0DP1 {
    public int rob(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;

        final int N = nums.length;
        int[] memo = new int[N + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        
        for(int i = 1; i < N; i++){
            int val = nums[i];
            memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
        }
        
        return memo[N];
    }
}