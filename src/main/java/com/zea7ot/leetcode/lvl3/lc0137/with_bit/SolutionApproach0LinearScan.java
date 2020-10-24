/**
 * https://leetcode.com/problems/single-number-ii/
 * 
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0137.with_bit;

public class SolutionApproach0LinearScan {
    private static final int INTEGER_TYPE_RANGE = 32;

    public int singleNumber(int[] nums) {
        // not used
        // final int N = nums.length;

        // to count the bit frequencies
        int[] freqs = new int[INTEGER_TYPE_RANGE];
        for (int num : nums) {
            countBitFreqs(num, freqs);
        }

        // to erase the bits that appear three times
        for (int i = 0; i < INTEGER_TYPE_RANGE; ++i) {
            freqs[i] %= 3;
        }

        // to acquire the single number
        int single = 0;
        for (int i = 0; i < INTEGER_TYPE_RANGE; ++i) {
            single ^= (freqs[i] << i);
        }

        return single;
    }

    private void countBitFreqs(int shift, int[] freqs) {
        for (int i = 0; i < INTEGER_TYPE_RANGE; ++i) {
            freqs[i] += (shift >> i) & 1;
        }
    }
}