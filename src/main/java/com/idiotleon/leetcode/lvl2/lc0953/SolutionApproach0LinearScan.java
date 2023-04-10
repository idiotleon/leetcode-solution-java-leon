/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 * 
 * Time Complexity:     O(N * L) + O(L) ~ O(N * L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/verifying-an-alien-dictionary/discuss/203185/JavaC%2B%2BPython-Mapping-to-Normal-Order
 */
package com.idiotleon.leetcode.lvl2.lc0953;

public class SolutionApproach0LinearScan {
    public boolean isAlienSorted(String[] words, String order) {
        // sanity check
        if (words == null || words.length < 2)
            return true;

        final int N = words.length;
        final int L = order.length();
        final int[] DICT = new int[26];
        final char[] CHS = order.toCharArray();
        for (int i = 0; i < L; ++i)
            DICT[CHS[i] - 'a'] = i;

        for (int i = 1; i < N; ++i)
            if (isBigger(words[i - 1], words[i], DICT))
                return false;

        return true;
    }

    private boolean isBigger(String prevWord, String curWord, final int[] DICT) {
        final int LEN_PREV = prevWord.length(), LEN_CUR = curWord.length();
        final int LEN = Math.min(LEN_PREV, LEN_CUR);

        for (int i = 0; i < LEN; ++i) {
            final char CH_PREV = prevWord.charAt(i);
            final char CH_CUR = curWord.charAt(i);
            if (CH_PREV == CH_CUR)
                continue;

            return DICT[CH_PREV - 'a'] > DICT[CH_CUR - 'a'];
        }

        return LEN_PREV > LEN_CUR;
    }
}