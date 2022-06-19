package com.an7one.leetcode.lvl4.lc0395;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/">Description</a>
 *
 * Time Complexity:     ?O(N)
 * Space Complexity:    O()
 *
 * a divide and conquer approach
 *
 * References:
 *  <a href="https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87738/Java-20-lines-very-easy-solution-7ms-with-explanation/394380">...</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DFSRecursive2 {
    public int longestSubstring(String str, int k) {
        // sanity check
        if (str == null || str.isEmpty())
            return 0;

        final int L = str.length();
        if (k < 2)
            return L;

        return dfs(str, 0, L, k);
    }

    private int dfs(String str, int lo, int hi, int k) {
        if (lo >= hi)
            return 0;
        final int L = str.length();
        char[] chs = str.toCharArray();

        // to build up the freq map
        int[] freq = new int[26];
        for (int i = lo; i < hi; i++)
            ++freq[chs[i] - 'a'];

        // to check if valid
        boolean isValid = true;
        for (int i = 0; i < 26 && isValid; i++) {
            if (freq[i] > 0 && freq[i] < k) {
                isValid = false;
            }
        }
        if (isValid)
            return hi - lo;

        // if not valid
        // to start a new split search,
        // for each invalid character,
        int longest = 0, start = lo, end = lo;
        while (end < L) {
            if (freq[chs[end] - 'a'] < k) {
                longest = Math.max(longest, dfs(str, start, end, k));
                start = end + 1;
            }

            ++end;
        }

        longest = Math.max(longest, dfs(str, start, hi, k));
        return longest;
    }
}