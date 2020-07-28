/**
 * https://leetcode.com/problems/task-scheduler/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/greedy/leetcode-621-task-scheduler/
 */
package com.zea7ot.lc.lvl4.lc0621;

public class SolutionApproach0Math {
    public int leastInterval(char[] tasks, int n) {
        final int N = tasks.length;

        int[] freq = new int[26];
        for (char task : tasks)
            ++freq[task - 'A'];

        int maxFreq = 0;
        for (int count : freq)
            maxFreq = Math.max(maxFreq, count);

        int ans = (maxFreq - 1) * (n + 1);
        for (int count : freq) {
            if (count == maxFreq) {
                ++ans;
            }
        }

        return Math.max(ans, N);
    }
}