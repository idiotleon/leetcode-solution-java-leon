/**
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2)
 */
package com.idiotleon.leetcode.lvl4.lc1312;

public class SolutionApproach0DFSMemo {
    public int minInsertions(String s) {
        // sanity check, not necessary
        // if (s == null || s.isEmpty())
        // return 0;

        final int L = s.length();
        Integer[][] memo = new Integer[L][L];
        return L - dfs(0, L - 1, s, memo);
    }

    private int dfs(int lo, int hi, String str, Integer[][] memo) {
        if (memo[lo][hi] != null)
            return memo[lo][hi];

        if (lo > hi)
            return 0;
        if (lo == hi)
            return 1;

        if (str.charAt(lo) == str.charAt(hi)) {
            memo[lo][hi] = dfs(lo + 1, hi - 1, str, memo) + 2;
        } else {
            memo[lo][hi] = Math.max(dfs(lo + 1, hi, str, memo), dfs(lo, hi - 1, str, memo));
        }

        return memo[lo][hi];
    }
}