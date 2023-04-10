/**
 * https://leetcode.com/problems/first-missing-positive/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/first-missing-positive/discuss/17214/Java-simple-solution-with-documentation
 */
package com.idiotleon.leetcode.lvl4.lc0041;

public class SolutionApproach0LinearScan {
    public int firstMissingPositive(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 1;

        final int N = nums.length;
        // to mark integers that are not in range as `N + 1`,
        // so that they can be ignored later on
        for (int i = 0; i < N; ++i)
            // 1-indexed
            if (nums[i] <= 0 || nums[i] > N)
                nums[i] = N + 1;

        // to mark each cell that appears in the array,
        // by turning the index of that number negative
        for (int i = 0; i < N; ++i) {
            int num = Math.abs(nums[i]);
            if (num > N)
                continue;

            --num; // to turn into 0-indexed
            if (nums[num] > 0)
                nums[num] *= -1;
        }

        // to find the first cell which is not negative
        for (int i = 0; i < N; ++i)
            if (nums[i] >= 0)
                return i + 1;

        return N + 1;
    }
}
