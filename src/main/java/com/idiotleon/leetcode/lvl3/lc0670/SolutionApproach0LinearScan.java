package com.idiotleon.leetcode.lvl3.lc0670;

import com.idiotleon.util.Constant;

/**
 * https://leetcode.com/problems/maximum-swap/
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * <p>
 * `nextMaxIndices` contains the index of the rightmost largest digit to the right of digit `i` in `num`
 * <p>
 * References:
 * https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time/642930
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0LinearScan {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        final int L = digits.length;

        int[] nextMaxIndices = new int[L];
        int maxIdx = L - 1;
        for (int i = L - 1; i >= 0; --i) {
            nextMaxIndices[i] = maxIdx;
            if (digits[maxIdx] - '0' < digits[i] - '0')
                maxIdx = i;
        }

        for (int i = 0; i < L; ++i) {
            if (digits[i] - '0' < digits[nextMaxIndices[i]] - '0') {
                swap(i, nextMaxIndices[i], digits);
                break;
            }
        }

        return Integer.parseInt(String.valueOf(digits));
    }

    private void swap(int i, int j, final char[] chs) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}