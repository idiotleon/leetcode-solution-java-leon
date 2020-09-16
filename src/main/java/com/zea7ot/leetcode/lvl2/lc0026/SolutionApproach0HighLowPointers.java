/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0026;

public class SolutionApproach0HighLowPointers {
    public int removeDuplicates(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int lo = 1, hi = 1;
        while (hi < N) {
            while (hi < N && nums[hi - 1] == nums[hi])
                ++hi;

            if (hi < N) {
                nums[lo] = nums[hi];
                ++lo;
            }

            ++hi;
        }

        return lo;
    }
}