/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/longest-continuous-increasing-subsequence/discuss/107365/JavaC%2B%2BClean-solution
 */
package com.an7one.leetcode.lvl2.lc0674;

public class SolutionApproach0Greedy {
    public int findLengthOfLCIS(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int longest = 0;
        int len = 0;

        for (int i = 0; i < N; i++) {
            if (i == 0 || nums[i - 1] < nums[i]) {
                longest = Math.max(longest, ++len);
            } else {
                len = 1;
            }
        }
        return longest;
    }
}