/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-size-subarray-sum/discuss/433123
 *  https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59078/Accepted-clean-Java-O(n)-solution-(two-pointers)
 */
package com.zea7ot.leetcode.lvl3.lc0209;

public class SolutionApproach0SlidingWindow {
    public int minSubArrayLen(final int S, int[] nums) {
        final int N = nums.length;

        int shortest = N + 1;

        int lo = 0, hi = 0;
        int sum = 0;
        while (hi < N) {
            sum += nums[hi];

            while (sum >= S) {
                shortest = Math.min(shortest, hi - lo + 1);
                sum -= nums[lo];
                ++lo;
            }

            ++hi;
        }

        return shortest == N + 1 ? 0 : shortest;
        // or equivalently
        // return shortest % (N + 1);
    }
}
