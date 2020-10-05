/**
 * https://leetcode.com/problems/longest-string-chain/
 * 
 * Time Complexity:     O(N * lg(N)) + O((N ^ 2) * L)
 *  O(N * lg(N)), consumed by sorting
 *  O(N ^ 2 * L), consumed by DP
 * 
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/longest-string-chain/discuss/294890/C%2B%2BJavaPython-DP-Solution
 */
package com.zea7ot.leetcode.lvl3.lc1048;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen {
    public int longestStrChain(String[] words) {
        // sanity check
        if (words == null || words.length == 0)
            return 0;
        final int N = words.length;
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int longest = 0;

        for (int hi = 1; hi < N; ++hi) {
            for (int lo = 0; lo < hi; ++lo) {
                String word1 = words[lo];
                String word2 = words[hi];
                if (word2.length() - word1.length() <= 1) {
                    if (isPredecessor(word1, word2)) {
                        dp[hi] = Math.max(dp[hi], dp[lo] + 1);
                    }
                }
            }

            longest = Math.max(longest, dp[hi]);
        }

        return longest;
    }

    // to check whether `word1` is a predecessor of `word2`
    private boolean isPredecessor(String word1, String word2) {
        final int L1 = word1.length(), L2 = word2.length();
        if (L1 == L2)
            return false;

        final char[] CHS1 = word1.toCharArray();
        final char[] CHS2 = word2.toCharArray();
        int diff = 0;
        int idx1 = 0, idx2 = 0;
        while (idx1 < L1) {
            if (CHS1[idx1] == CHS2[idx2]) {
                ++idx1;
                ++idx2;
            } else {
                if (++diff > 1)
                    return false;
                ++idx2;
            }
        }

        return true;
    }
}