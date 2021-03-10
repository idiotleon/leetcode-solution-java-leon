/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1) / O(N)
 */
package com.an7one.leetcode.lvl1.lc0977;

public class SolutionApproach0HighLowPointers {
    public int[] sortedSquares(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return new int[0];

        final int N = nums.length;
        int[] ans = new int[N];

        int lo = 0, hi = N - 1, idx = N - 1;

        while (lo <= hi) {
            if (Math.abs(nums[lo]) < Math.abs(nums[hi])) {
                ans[idx--] = nums[hi] * nums[hi];
                --hi;
            } else {
                ans[idx--] = nums[lo] * nums[lo];
                ++lo;
            }
        }

        return ans;
    }
}