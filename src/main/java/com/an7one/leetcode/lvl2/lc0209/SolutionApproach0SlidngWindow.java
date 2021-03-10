/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 */
package com.an7one.leetcode.lvl2.lc0209;

public class SolutionApproach0SlidngWindow {
    public int minSubArrayLen(int s, int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int shortest = Integer.MAX_VALUE;
        int sum = 0;
        int lo = 0, hi = 0;
        while (hi < N) {
            sum += nums[hi];
            while (sum >= s) {
                shortest = Math.min(shortest, hi - lo + 1);
                sum -= nums[lo];
                ++lo;
            }

            ++hi;
        }

        return shortest == Integer.MAX_VALUE ? 0 : shortest;
    }
}
