/**
 * https://leetcode.com/problems/maximum-swap/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * `nextMaxIdxes` contains the index of the rightmost largest digit to the right of digit `i` in `num`
 * 
 * References:
 *  https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time/642930
 */
package com.an7one.leetcode.lvl3.lc0670;

public class SolutionApproach0LinearScan {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        final int L = digits.length;

        int[] nextMaxIdxes = new int[L];
        int maxIdx = L - 1;
        for (int i = L - 1; i >= 0; --i) {
            nextMaxIdxes[i] = maxIdx;
            if (digits[maxIdx] - '0' < digits[i] - '0')
                maxIdx = i;
        }

        for (int i = 0; i < L; ++i) {
            if (digits[i] - '0' < digits[nextMaxIdxes[i]] - '0') {
                swap(i, nextMaxIdxes[i], digits);
                break;
            }
        }

        return Integer.valueOf(String.valueOf(digits));
    }

    private void swap(int i, int j, final char[] CHS) {
        char temp = CHS[i];
        CHS[i] = CHS[j];
        CHS[j] = temp;
    }
}