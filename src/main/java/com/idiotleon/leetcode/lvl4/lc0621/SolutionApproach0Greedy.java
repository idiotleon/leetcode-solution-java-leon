package com.idiotleon.leetcode.lvl4.lc0621;

import com.idiotleon.util.Constant;

/**
 * https://leetcode.com/problems/task-scheduler/
 * <p>
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * http://zxi.mytechroad.com/blog/greedy/leetcode-621-task-scheduler/
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Greedy {
    public int leastInterval(char[] tasks, int n) {
        final int N = tasks.length;

        int[] freqs = new int[26];
        for (char task : tasks) {
            ++freqs[task - 'A'];
        }

        int maxFreq = 0;
        for (int freq : freqs) {
            maxFreq = Math.max(maxFreq, freq);
        }

        int ans = (maxFreq - 1) * (n + 1);
        for (int freq : freqs) {
            if (freq == maxFreq) {
                ++ans;
            }
        }

        return Math.max(ans, N);
    }
}