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

public class SolutionApproach0Stack2 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        final int SIZE = logs.size();
        final String START = "start";

        Deque<Integer> stack = new ArrayDeque<Integer>();
        String[] log = logs.get(0).split(":");
        stack.add(Integer.parseInt(log[0]));
        int prevTimestamp = Integer.parseInt(log[2]);

        for (int i = 1; i < SIZE; ++i) {
            log = logs.get(i).split(":");

            int id = Integer.parseInt(log[0]);
            String state = log[1];
            int timestamp = Integer.parseInt(log[2]);

            if (state.equals(START)) {
                if (!stack.isEmpty())
                    ans[stack.peek()] += timestamp - prevTimestamp;

                stack.add(id);
                prevTimestamp = timestamp;
            } else {
                ans[stack.pop()] += timestamp - prevTimestamp + 1;
                prevTimestamp = timestamp + 1;
            }
        }

        return ans;
    }
}