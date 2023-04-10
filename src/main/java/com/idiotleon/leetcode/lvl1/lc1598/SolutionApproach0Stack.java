/**
 * @author: Leon
 * https://leetcode.com/problems/crawler-log-folder/
 *
 * Time Complexity:     O(`N` * AVE_LEN_LOG)
 * Space Complexity:    O(`N`)
 */
package com.idiotleon.leetcode.lvl1.lc1598;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack {
    private static final String MOVE_TO_PARENT = "../";
    private static final String REMAIN = "./";

    public int minOperations(String[] logs) {
        Deque<String> stack = new ArrayDeque<>();

        for (String log : logs) {
            switch (log) {
                case MOVE_TO_PARENT:
                    if (!stack.isEmpty())
                        stack.pop();
                    break;
                case REMAIN:
                    // to do nothing
                    break;
                default:
                    stack.push(log);
            }
        }

        return stack.size();
    }
}
