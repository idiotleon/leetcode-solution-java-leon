/**
 * https://leetcode.com/problems/house-robber-ii/
 * 
 * Time Complexity: O(2 * N) ~ O(N)
 * Space Complexity: O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0213;

public class SolutionApproachDP {
    public int rob(int[] nums){
        // sanity check
        if(nums == null || nums.length == 0) return 0;

        final int L = nums.length;
        if(L == 1) return nums[0];

        // if the first one is going to be robbed
        int robFirst = rob(nums, 0, L - 2);
        // if the second one is going to be robbed
        int robSecond = rob(nums, 1, L - 1);

        return Math.max(robFirst, robSecond);
    }

    private int rob(int[] nums, int from, int to){
        int include = 0, exclude = 0;

        for(int j = from; j <= to; j++){
            int i = include, e = exclude;
            // if this one is going to be robbed,
            // the previous one should be included
            include = e + nums[j];
            // if this one is NOT going to be robbed
            exclude = Math.max(e, i);
        }

        return Math.max(include, exclude);
    }
}