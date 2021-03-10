/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl3.lc0080;

public class SolutionApproach0LinearScan {
    public int removeDuplicates(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        int idx = 0;
        for (int num : nums) {
            if (idx < 2 || num > nums[idx - 2]) {
                nums[idx++] = num;
            }
        }

        return idx;
    }
}