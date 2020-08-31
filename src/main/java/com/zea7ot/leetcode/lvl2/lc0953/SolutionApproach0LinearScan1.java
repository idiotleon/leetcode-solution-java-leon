/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 * 
 * Time Complexity:     O(N * L)
 * Space Complexity:    O(L)
 */
package com.zea7ot.leetcode.lvl2.lc0953;

public class SolutionApproach0LinearScan1 {
    public boolean isAlienSorted(String[] words, String order) {
        final int L = order.length();
        char[] chs = order.toCharArray();
        final int N = words.length;

        int[] dict = new int[26];
        for (int i = 0; i < L; i++)
            dict[chs[i] - 'a'] = i;

        search: for (int i = 0; i < N - 1; i++) {
            String word1 = words[i], word2 = words[i + 1];
            final int LEN1 = word1.length(), LEN2 = word2.length();
            for (int k = 0; k < Math.min(LEN1, LEN2); ++k) {
                char ch1 = word1.charAt(k), ch2 = word2.charAt(k);
                if (ch1 != ch2) {
                    if (dict[ch1 - 'a'] > dict[ch2 - 'a']) {
                        return false;
                    }

                    continue search;
                }
            }

            if (LEN1 > LEN2)
                return false;
        }

        return true;
    }
}