/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2) + O(L)/O(1)
 * 
 *  `dp[i][j]`, the length of lognest palindromic subsequence, 
 *      in the `s[i : j]` (both ends inclusive)
 *  `i`, the left index
 *  `j`, the right index
 * 
 * State Transition:
 *  if `s.charAt(i) == s.charAt(j)`
 *      dp[i][j] = dp[i + 1][j - 1] + 2, 
 *      because the result of `s[i : j]` comes from the result of `s[i + 1 : j - 1]`, 
 *      which represents the solution/result of the substring trimmed BOTH ends
 *  else
 *      dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1])
 *      because the result/solution of `s[i : j]` consists of results/solution of subproblems: `s[i : j - 1]` and `s[i + 1 : j]`
 * 
 * Initialization:
 *  dp[i][i] = 1
 * 
 * 
 * References:
 *  https://www.youtube.com/watch?v=_nCsPn7_OgI
 *  https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution/103142
 *  https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
 *  https://youtu.be/FLbqgyJ-70I?t=6680
 */
package com.zea7ot.leetcode.lvl4.lc0516;

public class SolutionApproach0DP2Dimen1 {
    public int longestPalindromeSubseq(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        char[] chs = s.toCharArray();

        int[][] dp = new int[L][L];

        for (int i = L - 1; i >= 0; --i) {
            dp[i][i] = 1; // base case
            for (int j = i + 1; j < L; ++j) {
                if (chs[i] == chs[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][L - 1];
    }
}