/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87741/Java-divide-and-conquer(recursion)-solution
 */
package com.zea7ot.leetcode.lvl4.lc0395;

public class SolutionApproach1DivideAndConquer {
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
        if (hi - lo + 1 < K)
            return 0;

        int[] freq = new int[26];
        for (int i = lo; i <= hi; ++i)
            ++freq[CHS[i] - 'a'];

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            if (freq[ch - 'a'] == 0 || freq[ch - 'a'] >= K)
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