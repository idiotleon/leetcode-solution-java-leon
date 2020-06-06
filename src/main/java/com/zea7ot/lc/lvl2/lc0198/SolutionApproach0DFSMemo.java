/**
 * https://leetcode.com/problems/house-robber/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(N)
 * 
 * References:
 *  https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
package com.zea7ot.lc.lvl2.lc0198;

import java.util.Arrays;

public class SolutionApproach0DFSMemo {
    public int rob(int[] nums) {
        final int N = nums.length;
        int[] memo = new int[N + 1];
        Arrays.fill(memo, -1);
        return rob(nums, N - 1, memo);
    }
    
    private int rob(int[] nums, int i, int[] memo){
        if(i < 0) return 0;
        if(memo[i] >= 0) return memo[i];
        int result = Math.max(rob(nums, i - 2, memo) + nums[i], rob(nums, i - 1, memo));
        memo[i] = result;
        return result;
    }
}