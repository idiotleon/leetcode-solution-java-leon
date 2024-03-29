package com.idiotleon.leetcode.lvl4.lc0395;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/">Descripion</a>
 *
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L)
 *
 * References:
 *  <a href="https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87741/Java-divide-and-conquer(recursion)-solution">...</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DFSRecursive {
    public int longestSubstring(String s, int k) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        if (k < 2)
            return L;

        return dfs(0, L - 1, s.toCharArray(), k);
    }

    private int dfs(int lo, int hi, final char[] CHS, final int K) {
        final int LEN = hi - lo + 1;
        if (LEN < K)
            return 0;

        final int[] FREQS = new int[26];
        for (int i = lo; i <= hi; ++i)
            ++FREQS[CHS[i] - 'a'];

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            if (FREQS[ch - 'a'] == 0 || FREQS[ch - 'a'] >= K)
                continue;
            for (int j = lo; j <= hi; ++j) {
                if (CHS[j] != ch)
                    continue;
                int left = dfs(lo, j - 1, CHS, K);
                int right = dfs(j + 1, hi, CHS, K);
                return Math.max(left, right);
            }
        }

        return hi - lo + 1;
    }
}