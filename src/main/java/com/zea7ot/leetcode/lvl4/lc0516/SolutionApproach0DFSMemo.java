/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Compelxity:    O(L ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
 *  https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution/162610
 */
package com.zea7ot.leetcode.lvl4.lc0516;

public class SolutionApproach0DFSMemo {
    public int longestPalindromeSubseq(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;
        final int L = s.length();
        Integer[][] memo = new Integer[L][L];
        return dfs(0, L - 1, s, memo);
    }

    private int dfs(int i, int j, String str, Integer[][] memo) {
        if (memo[i][j] != null)
            return memo[i][j];

        if (i > j)
            return 0;
        if (i == j)
            return 1;

        if (str.charAt(i) == str.charAt(j)) {
            memo[i][j] = dfs(i + 1, j - 1, str, memo) + 2;
        } else {
            memo[i][j] = Math.max(dfs(i + 1, j, str, memo), dfs(i, j - 1, str, memo));
        }

        return memo[i][j];
    }
}