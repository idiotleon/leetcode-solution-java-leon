/**
 * https://leetcode.com/problems/maximum-width-ramp/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-width-ramp/discuss/265765/Detailed-Explaination-of-all-the-three-approaches
 */
package com.an7one.leetcode.lvl3.lc0962;

public class SolutionApproach0TwoPointers {
    public int maxWidthRamp(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int[] rightMax = new int[N];
        rightMax[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int lo = 0, hi = 0;
        int widest = 0;

        while (hi < N) {
            while (lo < hi && rightMax[hi] < nums[lo]) {
                ++lo;
            }

            widest = Math.max(widest, hi - lo);
            ++hi;
        }

        return widest;
    }
}
