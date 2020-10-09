/**
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * TLEed
 * 
 * References:
 *  https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/C++JavaPython-O(N)-Using-Deque/150644
 *  https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/
 */
package com.zea7ot.leetcode.lvl5.lc0862;

public class SolutionApproach1DP1Dimen {
    public int shortestSubarray(int[] nums, int K) {
        final int N = nums.length;

        int[] prefixSums = new int[N + 1];
        int shortest = N + 1;

        for (int hi = 1; hi <= N; ++hi) {
            prefixSums[hi] = prefixSums[hi - 1] + nums[hi - 1];

            for (int lo = hi - 1; lo >= 0; --lo) {
                if (prefixSums[hi] - prefixSums[lo] >= K) {
                    shortest = Math.min(shortest, hi - lo);
                }
            }
        }

        return shortest == (N + 1) ? -1 : shortest;
    }
}
