/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl2.lc0026;

public class SolutionApproach0HighLowPointers1 {
    public int removeDuplicates(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int lo = 1;
        for (int hi = 1; hi < N; ++hi) {
            if (nums[hi - 1] == nums[hi])
                continue;

            nums[lo] = nums[hi];
            ++lo;
        }

        return lo;
    }
}