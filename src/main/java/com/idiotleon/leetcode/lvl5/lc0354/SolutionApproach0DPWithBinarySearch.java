/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 * 
 * References:  
 *  https://leetcode.com/problems/russian-doll-envelopes/discuss/82763/Java-NLogN-Solution-with-Explanation/87015
 *  https://leetcode.com/problems/russian-doll-envelopes/discuss/82763/Java-NLogN-Solution-with-Explanation/87032
 */
package com.idiotleon.leetcode.lvl5.lc0354;

import java.util.Arrays;

public class SolutionApproach0DPWithBinarySearch {
    public int maxEnvelopes(int[][] envelopes) {
        // sanity check
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length < 2)
            return 0;

        final int N = envelopes.length;
        // to sort:
        // 1. with width increasing
        // 2. with the same width(s), with height decreasing
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int[] dp = new int[N];
        int size = 0;

        for (int[] envelope : envelopes) {
            int lo = 0, hi = size;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (dp[mid] < envelope[1])
                    lo = mid + 1;
                else
                    hi = mid;
            }

            dp[lo] = envelope[1];

            if (lo == size) {
                ++size;
            }
        }

        return size;
    }
}