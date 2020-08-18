/**
 * https://leetcode.com/problems/previous-permutation-with-one-swap/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References: 
 *  https://leetcode.com/problems/previous-permutation-with-one-swap/discuss/299244/Similar-to-find-previous-permutation-written-in-Java
 */
package com.zea7ot.leetcode.lvl3.lc1053;

public class SolutionApproach0Math {
    public int[] prevPermOpt1(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 2)
            return nums;

        final int N = nums.length;
        int idx = -1;
        for (int i = N - 1; i >= 1; --i)
            if (nums[i] < nums[i - 1]) {
                idx = i - 1;
                break;
            }

        if (idx == -1)
            return nums;

        for (int i = N - 1; i > idx; --i) {
            if (nums[i] < nums[idx] && nums[i] != nums[i - 1]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        return nums;
    }
}