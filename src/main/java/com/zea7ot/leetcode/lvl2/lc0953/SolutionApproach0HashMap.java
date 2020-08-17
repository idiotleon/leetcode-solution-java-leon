/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 * 
 * Time Complexity:     O(N * L) + O(L) ~ O(N * L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/verifying-an-alien-dictionary/discuss/203185/JavaC%2B%2BPython-Mapping-to-Normal-Order
 */
package com.zea7ot.leetcode.lvl2.lc0953;

public class SolutionApproach0HashMap {
    public boolean isAlienSorted(String[] words, String order) {
        final int L = order.length();
        char[] chs = order.toCharArray();
        final int N = words.length;

        int[] dict = new int[L];
        for (int i = 0; i < L; i++)
            dict[chs[i] - 'a'] = i;

        for (int i = 1; i < N; i++)
            if (breaksOrder(words[i - 1], words[i], dict))
                return false;

        return true;
    }

    private boolean breaksOrder(String word1, String word2, int[] dict) {
        final int LEN1 = word1.length(), LEN2 = word2.length();

        for (int i = 0; i < Math.min(LEN1, LEN2); ++i) {
            char ch1 = word1.charAt(i), ch2 = word2.charAt(i);
            if (ch1 != ch2) {
                return dict[ch1 - 'a'] > dict[ch2 - 'a'];
            }
        }

        return LEN1 > LEN2;
    }
}