/**
 * https://leetcode.com/problems/shortest-palindrome/
 * 
 * Time Complexity:     ?O(L)
 * Space Complexity:    ?O(L)
 * 
 * References:
 *  https://leetcode.com/problems/shortest-palindrome/discuss/60153/8-line-O(n)-method-using-Rabin-Karp-rolling-hash/61282
 *  https://leetcode.com/problems/shortest-palindrome/discuss/60153/8-line-O(n)-method-using-Rabin-Karp-rolling-hash
 *  https://cs.stackexchange.com/a/28024
 */
package com.an7one.leetcode.lvl5.lc0214;

public class SolutionApproach0RollingHash {
    private static final long BASE = 29L;
    private static final long MOD = (long) 1e9 + 7;

    public String shortestPalindrome(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return "";

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        int idx = -1;
        long pow = 1L;
        long hash1 = 0L, hash2 = 0L;
        for (int i = 0; i < L; ++i) {
            hash1 = (hash1 * BASE + CHS[i] - 'a' + 1) % MOD;
            hash2 = (hash2 + (CHS[i] - 'a' + 1) * pow) % MOD;

            if (hash1 == hash2)
                idx = i;
            pow = pow * BASE % MOD;
        }

        return new StringBuilder().append(s.substring(idx + 1, L)).reverse().append(s).toString();
    }
}
