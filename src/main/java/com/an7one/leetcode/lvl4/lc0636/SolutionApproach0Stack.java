/**
 * https://leetcode.com/problems/exclusive-time-of-functions/
 * 
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 * 
 * `stack` is used to save the IDs, which should be pused in if it is a start, of functions
 * 
 * References:
 *  https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space
 *  https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space/107796
 */
package com.an7one.leetcode.lvl4.lc0636;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0Stack {
    private static final String START = "start";
    private static final String SPLITTER = ":";

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        // sanity check
        if (n == 0 || logs.isEmpty())
            return ans;

        Deque<Integer> stack = new ArrayDeque<>();
        int prevTimestamp = 0;

        for (String log : logs) {
            String[] res = log.split(SPLITTER);
            int id = Integer.parseInt(res[0]);
            String state = res[1];
            int curTimestamp = Integer.parseInt(res[2]);

            if (!stack.isEmpty())
                ans[stack.peek()] += curTimestamp - prevTimestamp;

            prevTimestamp = curTimestamp;

            if (state.equals(START))
                stack.push(id);
            else {
                ++ans[stack.pop()];
                ++prevTimestamp;
            }
        }

        return ans;
    }
}