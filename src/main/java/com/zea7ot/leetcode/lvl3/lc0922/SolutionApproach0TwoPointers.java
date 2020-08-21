/**
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/sort-array-by-parity-ii/discuss/181160/Java-two-pointer-one-pass-inplace
 */
package com.zea7ot.leetcode.lvl3.lc0922;

public class SolutionApproach0TwoPointers {
    public int[] sortArrayByParityII(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return nums;

        final int N = nums.length;
        int even = 0, odd = 1;

        while (odd < N && even < N) {
            if (nums[even] % 2 == 0)
                even += 2;

            if (nums[odd] % 2 == 1)
                odd += 2;

            if (even < N && odd < N)
                swap(even, odd, nums);
        }

        return nums;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}