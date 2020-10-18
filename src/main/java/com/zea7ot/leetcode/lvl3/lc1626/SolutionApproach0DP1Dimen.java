/**
 * https://leetcode.com/problems/best-team-with-no-conflicts/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N ^ 2) ~ O(N ^ 2)
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl3.lc1626;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen {
    public int bestTeamScore(int[] scores, int[] ages) {
        final int N = scores.length;
        Player[] players = new Player[N];
        for (int i = 0; i < N; ++i) {
            players[i] = new Player(ages[i], scores[i]);
        }

        Arrays.sort(players,
                (a, b) -> a.age == b.age ? Integer.compare(a.score, b.score) : Integer.compare(a.age, b.age));

        int maxScore = -1;
        int[] dp = new int[N];

        for (int hi = 0; hi < N; ++hi) {
            dp[hi] = players[hi].score;
            for (int lo = hi - 1; lo >= 0; --lo) {
                if (players[lo].score > players[hi].score)
                    continue;
                dp[hi] = Math.max(dp[hi], players[hi].score + dp[lo]);
            }

            maxScore = Math.max(maxScore, dp[hi]);
        }

        return maxScore;
    }

    private class Player {
        private int age;
        private int score;

        private Player(int age, int score) {
            this.age = age;
            this.score = score;
        }
    }
}
