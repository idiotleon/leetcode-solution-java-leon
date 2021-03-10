/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59103/Two-AC-solutions-in-Java-with-time-complexity-of-N-and-NLogN-with-explanation
 */
package com.an7one.leetcode.lvl3.lc0209.followup;

public class SolutionApproach0BinarySearch {
    public int minSubArrayLen(final int S, int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int[] prefixSums = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }
        if (prefixSums[N] < S)
            return 0;

        int shortest = N + 1;

        for (int i = 0; i <= N; ++i) {
            int end = binarySearch(i + 1, N, prefixSums, S + prefixSums[i]);

            if (end == N + 1)
                break;
            if (end - i < shortest)
                shortest = end - i;
        }

        return shortest % (N + 1);
    }

    private int binarySearch(int lo, int hi, int[] sums, int key) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (sums[mid] >= key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
