/**
 * https://leetcode.com/problems/first-missing-positive/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl4.lc0041;

public class SolutionApproach0LinearScan1 {
    public int firstMissingPositive(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 1;

        final int N = nums.length;
        int idx = 0;
        while (idx < N) {
            if (nums[idx] == idx + 1 || nums[idx] <= 0 || nums[idx] > N)
                ++idx;
            else if (nums[nums[idx] - 1] != nums[idx])
                swap(idx, nums[idx] - 1, nums);
            else
                ++idx;
        }

        idx = 0;
        while (idx < N && nums[idx] == idx + 1)
            ++idx;

        return idx + 1;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}