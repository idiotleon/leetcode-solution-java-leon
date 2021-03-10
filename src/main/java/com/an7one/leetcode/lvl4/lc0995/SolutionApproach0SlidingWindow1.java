/**
 * https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC++Python-One-Pass-and-O(1)-Space/236804
 *  https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC++Python-One-Pass-and-O(1)-Space/252674
 *  https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC%2B%2BPython-One-Pass-and-O(1)-Space
 */
package com.an7one.leetcode.lvl4.lc0995;

public class SolutionApproach0SlidingWindow1 {
    public int minKBitFlips(int[] nums, int K) {
        final int N = nums.length;

        boolean[] isFlipped = new boolean[N];

        // the window of flipped
        // the valid flips from the past sliding window `K` till the current index
        int flippedWindow = 0;

        // counter of the actual flips performed
        int flipsCounter = 0;

        for (int i = 0; i < N; ++i) {
            if (i >= K && isFlipped[i - K]) {
                --flippedWindow;
            }

            if (flippedWindow % 2 == nums[i]) {
                if (i + K > N)
                    return -1;

                ++flippedWindow;
                isFlipped[i] = true;

                ++flipsCounter;
            }
        }

        return flipsCounter;
    }
}
