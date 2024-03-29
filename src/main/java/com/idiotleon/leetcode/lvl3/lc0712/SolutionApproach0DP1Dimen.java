package com.idiotleon.leetcode.lvl3.lc0712;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/">LC0712</a>
 * <p>
 * Time Complexity:     O(L1 * L2)
 * Space Complexity:    O(L2)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/108828/C%2B%2B-DP-with-explanation">LC Discussion</a>
 * <a href="https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/642422/for-those-who-have-no-clue-%3A-step-by-step">LC Discussion</a>
 * <a href="https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/161054/Java-O(nm)-time-and-O(n)-space-solution">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP1Dimen {
    public int minimumDeleteSum(String s1, String s2) {
        final int L1 = s1.length(), L2 = s2.length();
        int[] dp = new int[L2 + 1];
        for (int j = 1; j <= L2; j++) {
            dp[j] = dp[j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= L1; i++) {
            int prev = dp[0];
            dp[0] += s1.charAt(i - 1);
            for (int j = 1; j <= L2; j++) {
                int cur = dp[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    dp[j] = Math.min(dp[j] + s1.charAt(i - 1), dp[j - 1] + s2.charAt(j - 1));
                }
                prev = cur;
            }
        }

        return dp[L2];
    }
}