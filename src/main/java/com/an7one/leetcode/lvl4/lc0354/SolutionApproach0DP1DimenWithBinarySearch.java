/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 *
 * Time Complexity:     O(`N` * lg(`N`))
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/russian-doll-envelopes/discuss/82763/Java-NLogN-Solution-with-Explanation
 */
package com.an7one.leetcode.lvl4.lc0354;

import java.util.Arrays;

public class SolutionApproach0DP1DimenWithBinarySearch {
    public int maxEnvelopes(int[][] envelopes) {
        final int N = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int[] dp = new int[N];
        int size = 0;

        for (int[] envelope : envelopes) {
            int lo = 0, hi = size;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (dp[mid] < envelope[1]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }

            dp[lo] = envelope[1];

            if (lo == size) {
                ++size;
            }
        }

        return size;
    }
}
