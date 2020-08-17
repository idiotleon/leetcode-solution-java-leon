/**
 * https://leetcode.com/problems/exclusive-time-of-functions/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * `stack` is used to save the IDs, which should be pused in if it is a start, of functions
 * 
 * References:
 *  https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space
 *  https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space/107796
 */
package com.zea7ot.leetcode.lvl4.lc0636;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0Stack {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];

        final String START = "start";

        Deque<Integer> stack = new ArrayDeque<Integer>();
        int prevTimestamp = 0;

        for (String cur : logs) {
            String[] log = cur.split(":");
            int id = Integer.parseInt(log[0]);
            String state = log[1];
            int timestamp = Integer.parseInt(log[2]);

            if (!stack.isEmpty())
                ans[stack.peek()] += timestamp - prevTimestamp;

            prevTimestamp = timestamp;

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