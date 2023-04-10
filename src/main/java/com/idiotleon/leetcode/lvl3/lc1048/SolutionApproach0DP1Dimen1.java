/**
 * https://leetcode.com/problems/longest-string-chain/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N ^ 2 * L)
 *  O(N * lg(N)), consumed by sorting
 *  O(N ^ 2 * L), consumed by DP
 * 
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/longest-string-chain/discuss/294890/C%2B%2BJavaPython-DP-Solution
 */
package com.idiotleon.leetcode.lvl3.lc1048;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen1 {
    public int longestStrChain(String[] words) {
        // sanity check
        if (words == null || words.length == 0)
            return 0;

        final int N = words.length;
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        int[] dp = new int[N];
        int longest = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0 && words[i].length() - words[j].length() <= 1; j--) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            longest = Math.max(longest, dp[i]);
        }

        return longest;
    }

    // to check whether `str1` is a predecessor of `str2`
    private boolean isPredecessor(String str1, String str2) {
        final int L1 = str1.length(), L2 = str2.length();
        if (L1 == L2)
            return false;

        final char[] CHS1 = str1.toCharArray();
        final char[] CHS2 = str2.toCharArray();
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