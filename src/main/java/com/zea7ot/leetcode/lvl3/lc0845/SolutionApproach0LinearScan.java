/**
 * https://leetcode.com/problems/longest-mountain-in-array/
 * 
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/longest-mountain-in-array/discuss/135593/C++JavaPython-1-pass-and-O(1)-space/142630
 */
package com.zea7ot.leetcode.lvl3.lc0845;

public class SolutionApproach0LinearScan {
    public int longestMountain(int[] nums) {
        final int N = nums.length;

        int longest = 0;
        int idx = 1;

        while (idx < N) {
            while (idx < N && nums[idx - 1] >= nums[idx]) {
                ++idx;
            }

            int up = 0;
            while (idx < N && nums[idx - 1] < nums[idx]) {
                ++idx;
                ++up;
            }

            int down = 0;
            while (idx < N && nums[idx - 1] > nums[idx]) {
                ++idx;
                ++down;
            }

            if (up > 0 && down > 0) {
                longest = Math.max(longest, up + down + 1);
            }
        }

        return longest;
    }
}
