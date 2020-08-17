/**
 * https://leetcode.com/problems/total-hamming-distance/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/total-hamming-distance/discuss/96226/Java-O(n)-time-O(1)-Space
 */
package com.zea7ot.leetcode.lvl3.lc0477;

public class SolutionApproach0BitManipulation1 {
    public int totalHammingDistance(int[] nums) {
        final int N = nums.length;

        int total = 0;
        for (int i = 0; i < 32; ++i) {
            int bitCount = 0;
            for (int j = 0; j < N; ++j)
                bitCount += (nums[j] >> i) & 1;

            total += bitCount * (N - bitCount);
        }

        return total;
    }
}