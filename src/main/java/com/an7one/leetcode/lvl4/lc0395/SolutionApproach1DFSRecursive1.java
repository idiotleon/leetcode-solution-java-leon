/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * 
 * Time Complexity:     ?O(L ^ 2)
 * Space Complexity:    O(L) + (L) ~ O(L)
 * 
 * a divide and conquer approach
 * 
 * References:
 *  https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87738/Java-20-lines-very-easy-solution-7ms-with-explanation/394380
 */
package com.an7one.leetcode.lvl4.lc0395;

public class SolutionApproach1DFSRecursive1 {
    public int longestSubstring(String str, int k) {
        // sanity check
        if (str == null || str.isEmpty())
            return 0;

        final int L = str.length();
        if (k < 2)
            return L;

        return dfs(0, L, str, k);
    }

    private int dfs(final int LO, final int HI, String str, final int K) {
        if (LO >= HI)
            return 0;
        final int LEN = HI - LO;
        final char[] CHS = str.toCharArray();

        final int[] FREQS = new int[26];
        for (int i = LO; i < HI; ++i)
            ++FREQS[CHS[i] - 'a'];

        // to check if valid
        boolean isValid = true;

        // if not valid
        // to start a new split search,
        // for each invalid character,
        int lo = LO, hi = LO;
        int longest = 0;
        while (hi < LO + LEN) {
            if (FREQS[CHS[hi] - 'a'] < K) {
                longest = Math.max(longest, dfs(lo, hi, str, K));
                isValid = false;
                lo = hi + 1;
            }

            ++hi;
        }

        return isValid ? LEN : Math.max(longest, dfs(lo, HI, str, K));
    }
}