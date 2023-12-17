package com.idiotleon.leetcode.lvl3.lc0477;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/total-hamming-distance/">LC0477</a>
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/total-hamming-distance/discuss/96226/Java-O(n)-time-O(1)-Space">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BitManipulation1 {
    public int totalHammingDistance(int[] nums) {
        final int N = nums.length;

        int total = 0;
        for (int i = 0; i < 32; ++i) {
            int bitCount = 0;
            for (final int num : nums) {
                bitCount += (num >> i) & 1;
            }

            total += bitCount * (N - bitCount);
        }

        return total;
    }
}