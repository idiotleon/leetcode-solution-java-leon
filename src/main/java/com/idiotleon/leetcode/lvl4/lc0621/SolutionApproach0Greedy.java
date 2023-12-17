package com.idiotleon.leetcode.lvl4.lc0621;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/task-scheduler/">LC0621</a>
 * <p>
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 * <p>
 * Reference:
 * <a href="http://zxi.mytechroad.com/blog/greedy/leetcode-621-task-scheduler/">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Greedy {
    public int leastInterval(final char[] tasks, final int n) {
        final int N = tasks.length;

        final int[] freqs = new int[26];
        for (final char task : tasks) {
            ++freqs[task - 'A'];
        }

        int maxFreq = 0;
        for (final int freq : freqs) {
            maxFreq = Math.max(maxFreq, freq);
        }

        int ans = (maxFreq - 1) * (n + 1);
        for (final int freq : freqs) {
            if (freq == maxFreq) {
                ++ans;
            }
        }

        return Math.max(ans, N);
    }
}