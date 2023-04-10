/**
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/discuss/355386/JavaPython-3-Sliding-Window-O(n)-code-w-brief-explanation-and-analysis.
 */
package com.idiotleon.leetcode.lvl2.lc1151;

public class SolutionApproach0SlidingWindow {
    public int minSwaps(int[] data) {
        final int N = data.length;

        int sum = 0;
        for (int num : data) {
            sum += num;
        }

        final int FIXED_SIZE = sum;

        int most = 0;
        int ones = 0;

        for (int i = 0; i < N; ++i) {
            ones += data[i];

            if (i > FIXED_SIZE - 1) {
                ones -= data[i - FIXED_SIZE];
            }

            most = Math.max(most, ones);
        }

        return FIXED_SIZE - most;
    }
}
