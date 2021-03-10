/**
 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 * 
 * Time Complexity:     O((N ^ 2) * `D`)
 * Space Complexity;    O(N * `D`)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/discuss/490316/JavaC%2B%2BPython3-DP-O(nd)-Solution
 */
package com.an7one.leetcode.lvl4.lc1335;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionApproach0DPWithMonoStack {
    public int minDifficulty(int[] jobDifficulty, int D) {
        final int N = jobDifficulty.length;
        if (N < D)
            return -1;

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        int[] next = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int d = 0; d < D; ++d) {
            stack.clear();
            for (int len = d; len < N; ++len) {
                next[len] = len > 0 ? dp[len - 1] + jobDifficulty[len] : jobDifficulty[len];
                while (!stack.isEmpty() && jobDifficulty[stack.peek()] <= jobDifficulty[len]) {
                    int idx = stack.pop();
                    next[len] = Math.min(next[len], next[idx] - jobDifficulty[idx] + jobDifficulty[len]);
                }

                if (!stack.isEmpty()) {
                    next[len] = Math.min(next[len], next[stack.peek()]);
                }

                stack.push(len);
            }

            dp = next.clone();
        }

        return dp[N - 1];
    }
}