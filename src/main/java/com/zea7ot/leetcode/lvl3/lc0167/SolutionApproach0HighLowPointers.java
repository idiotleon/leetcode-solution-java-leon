/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0167;

public class SolutionApproach0HighLowPointers {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int N = nums.length;

        int lo = 0, hi = N - 1;

        while (lo < hi) {
            int sum = nums[lo] + nums[hi];

            if (sum == target) {
                ans[0] = lo + 1;
                ans[1] = hi + 1;
                return ans;
            } else if (sum > target)
                --hi;
            else
                ++lo;
        }

        // since it is guaranteed that
        // "each input would have exactly one solution
        // and you may not use the same element twice."
        return ans;
    }
}