/**
 * https://leetcode.com/problems/sort-array-by-parity/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/sort-array-by-parity/discuss/170734/C%2B%2BJava-In-Place-Swap
 */
package com.an7one.leetcode.lvl1.lc0905;

public class SolutionApproachHighLowPointers {
    public int[] sortArrayByParity(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return new int[0];

        final int N = nums.length;
        int lo = 0, hi = 0;
        while (hi < N) {
            if (nums[hi] % 2 == 0) {
                swap(lo, hi, nums);
                ++lo;
            }

            ++hi;
        }

        return nums;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}