/**
 * https://leetcode.com/problems/sort-array-by-parity/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/sort-array-by-parity/discuss/170734/C++Java-In-Place-Swap/229675
 */
package com.idiotleon.leetcode.lvl1.lc0905;

public class SolutionApproachHighLowPointers1 {
    public int[] sortArrayByParity(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return new int[0];

        final int N = nums.length;
        int lo = 0, hi = N - 1;

        while (lo < hi) {
            if (nums[lo] % 2 == 0)
                ++lo;
            else {
                if (nums[hi] % 2 == 1)
                    --hi;
                else
                    swap(lo++, hi--, nums);
            }
        }

        return nums;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}