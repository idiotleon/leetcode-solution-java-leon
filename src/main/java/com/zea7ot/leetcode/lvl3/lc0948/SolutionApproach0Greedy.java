/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Time Complexity:     O(`N` * lg(`N`))
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://youtu.be/S9oUiVYEq7E
 *  https://leetcode.com/problems/longest-increasing-subsequence/solution/
 */
package com.zea7ot.leetcode.lvl3.lc0948;

import java.util.Arrays;

public class SolutionApproach0Greedy {
    public int bagOfTokensScore(int[] tokens, final int P) {
        Arrays.sort(tokens);

        final int N = tokens.length;
        int lo = 0, hi = N - 1;

        int power = P;
        int points = 0;

        int most = 0;

        while (lo <= hi) {
            if (power >= tokens[lo]) {
                power -= tokens[lo++];
                most = Math.max(most, ++points);
            } else if (points > 0) {
                power += tokens[hi--];
                --points;
            } else
                break;
        }

        return most;
    }
}
