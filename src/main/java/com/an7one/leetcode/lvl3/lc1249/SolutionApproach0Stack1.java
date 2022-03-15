package com.an7one.leetcode.lvl3.lc1249;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 *
 * References:
 *  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/419402/JavaC%2B%2B-Stack
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Stack1 {
    private static final char PLACE_HOLDER = '*';

    public String minRemoveToMakeValid(String s) {
        final int L = s.length();
        StringBuilder builder = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            char ch = builder.charAt(i);
            if (ch == '(') {
                stack.add(i);
            }

            if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    builder.setCharAt(i, PLACE_HOLDER);
                }
            }
        }

        while (!stack.isEmpty()) {
            builder.setCharAt(stack.pop(), PLACE_HOLDER);
        }

        return builder.toString().replaceAll("\\*", "");
    }
}