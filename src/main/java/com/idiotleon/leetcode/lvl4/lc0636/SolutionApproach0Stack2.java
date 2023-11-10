package com.idiotleon.leetcode.lvl4.lc0636;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/exclusive-time-of-functions/">LC0636</a>
 * <p>
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 * <p>
 * `stack` is used to save the IDs, which should be pushed in if it is a start, of functions
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space">LCDiscussion</a>
 * <a href="https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space/107796">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Stack2 {
    public int[] exclusiveTime(int n, List<String> logs) {
        final int[] ans = new int[n];
        final int SIZE = logs.size();
        final String START = "start";

        final Deque<Integer> stack = new ArrayDeque<>();
        String[] log = logs.get(0).split(":");
        stack.add(Integer.parseInt(log[0]));
        int prevTimestamp = Integer.parseInt(log[2]);

        for (int i = 1; i < SIZE; ++i) {
            log = logs.get(i).split(":");

            final int id = Integer.parseInt(log[0]);
            final String state = log[1];
            final int timestamp = Integer.parseInt(log[2]);

            if (state.equals(START)) {
                if (!stack.isEmpty()) {
                    ans[stack.peek()] += timestamp - prevTimestamp;
                }

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