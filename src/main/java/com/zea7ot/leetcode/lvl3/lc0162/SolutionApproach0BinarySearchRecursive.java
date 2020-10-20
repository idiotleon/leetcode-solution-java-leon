/**
 * https://leetcode.com/problems/find-peak-element/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(lg(N))
 */
package com.zea7ot.leetcode.lvl3.lc0162;

public class SolutionApproach0BinarySearchRecursive {
    public int findPeakElement(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        return dfs(0, N - 1, nums);
    }

    private int dfs(int lo, int hi, int[] nums) {
        if (lo == hi)
            return lo;

        int mid = lo + (hi - lo) / 2;
        if (nums[mid] > nums[mid + 1])
            return dfs(lo, mid, nums);
        else
            return dfs(mid + 1, hi, nums);
    }
}