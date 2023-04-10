/**
 * https://leetcode.com/problems/jump-game-v/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://mp.weixin.qq.com/s/kEQ00_WLqDTG6tbsjQ2Xjw
 */
package com.idiotleon.leetcode.lvl4.lc1340;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionApproach0DPWithMonoStack {
    public int maxJumps(int[] arr, int d) {
        final int N = arr.length;
        int[] padded = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            padded[i] = arr[i];
        }
        padded[N] = Integer.MAX_VALUE;

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);

        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        for (int i = 0; i <= N; ++i) {
            while (!stack1.isEmpty() && padded[stack1.peek()] < padded[i]) {
                int prev = padded[stack1.peek()];
                while (!stack1.isEmpty() && prev == padded[stack1.peek()]) {
                    int j = stack1.pop();
                    if (i - j <= d) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }

                    stack2.push(j);
                }

                while (!stack2.isEmpty()) {
                    int j = stack2.pop();
                    if (!stack1.isEmpty() && j - stack1.peek() <= d) {
                        dp[stack1.peek()] = Math.max(dp[stack1.peek()], dp[j] + 1);
                    }
                }
            }

            stack1.push(i);
        }

        int most = 0;
        for (int i = 0; i < N; ++i) {
            most = Math.max(most, dp[i]);
        }

        return most;
    }
}
