/**
 * https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC++Python-One-Pass-and-O(1)-Space/236804
 *  https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC++Python-One-Pass-and-O(1)-Space/252674
 *  https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC%2B%2BPython-One-Pass-and-O(1)-Space
 */
package com.idiotleon.leetcode.lvl4.lc0995;

public class SolutionApproach0SlidingWindow {
    private static final int MARK_FLIPPED = 2;

    public int minKBitFlips(int[] nums, int K) {
        final int N = nums.length;

        // the window of flipped
        // the valid flips from the past sliding window `K` till the current index
        int flippedWindow = 0;

        // counter of the actual flips performed
        int flipsCounter = 0;

        for (int i = 0; i < N; ++i) {
            // to narrow down the window
            if (i >= K && nums[i - K] > 1) {
                --flippedWindow;
                nums[i - K] -= MARK_FLIPPED;
            }

            // to enlarge the window
            if (flippedWindow % 2 == nums[i]) {
                if (i + K > N)
                    return -1;

                ++flippedWindow;
                nums[i] += MARK_FLIPPED;

                ++flipsCounter;
            }
        }

        return flipsCounter;
    }
}
