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
 * <a href="https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space>LCDiscussion</a>
 * <a href="https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space/107796">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Stack {
    private static final String START = "start";
    private static final String SPLITTER = ":";

    public int[] exclusiveTime(int n, List<String> logs) {
        final int[] ans = new int[n];
        // sanity check
        if (n == 0 || logs.isEmpty()) {
            return ans;
        }

        final Deque<Integer> stack = new ArrayDeque<>();
        int prevTimestamp = 0;

        for (String log : logs) {
            final String[] res = log.split(SPLITTER);
            final int id = Integer.parseInt(res[0]);
            final String state = res[1];
            final int curTimestamp = Integer.parseInt(res[2]);

            if (!stack.isEmpty()) {
                ans[stack.peek()] += curTimestamp - prevTimestamp;
            }

            prevTimestamp = curTimestamp;

            if (state.equals(START)) {
                stack.push(id);
            } else {
                ++ans[stack.pop()];
                ++prevTimestamp;
            }
        }

        return ans;
    }
}