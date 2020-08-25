/**
 * https://leetcode.com/problems/sort-colors/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0075;

public class SolutionApproach0ThreePointers1 {
    public void sortColors(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return;

        final int N = nums.length;

        int lo = 0, idx = 0, hi = N - 1, temp;
        while (idx <= hi) {
            if (nums[idx] == 0) {
                temp = nums[lo];
                nums[lo++] = nums[idx];
                nums[idx++] = temp;
            } else if (nums[idx] == 2) {
                temp = nums[idx];
                nums[idx] = nums[hi];
                nums[hi--] = temp;
            } else
                idx++;
        }
    }
}