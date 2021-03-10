/**
 * https://leetcode.com/problems/valid-palindrome-iii/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/valid-palindrome-iii/discuss/397606/Find-Longest-Palindromic-Subsequence.
 */
package com.an7one.leetcode.lvl4.lc1216;

public class SolutionApproach0DFSMemo {
    public boolean isValidPalindrome(String s, int k) {
        // sanity check, not necessary
        // if (s == null || s.isEmpty() || k <= 0)
        // return false;

        final int L = s.length();
        Integer[][] memo = new Integer[L][L];
        return L - dfs(0, L - 1, s, memo) <= k;
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