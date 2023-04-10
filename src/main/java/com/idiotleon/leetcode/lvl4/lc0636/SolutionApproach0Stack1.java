package com.idiotleon.leetcode.lvl4.lc0636;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/exclusive-time-of-functions/
 * <p>
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 * <p>
 * `stack` is used to save the IDs, which should be pused in if it is a start, of functions
 * <p>
 * References:
 * https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space/107796
 * https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Stack1 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];

        final String START = "start";

        Deque<Integer> stack = new ArrayDeque<>();
        int prevTimestamp = 0;

        for (String cur : logs) {
            String[] log = cur.split(":");
            int id = Integer.parseInt(log[0]);
            String state = log[1];
            int timestamp = Integer.parseInt(log[2]);

            if (state.equals(START)) {
                if (!stack.isEmpty())
                    ans[stack.peek()] += timestamp - prevTimestamp;

                stack.push(id);
                prevTimestamp = timestamp;
            } else {
                ans[stack.pop()] += timestamp - prevTimestamp + 1;
                prevTimestamp = timestamp + 1;
            }
        }

        return ans;
    }
}