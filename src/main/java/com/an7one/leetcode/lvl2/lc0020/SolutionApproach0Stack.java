package com.an7one.leetcode.lvl2.lc0020;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * <p>
 * Time Complexity:     O(`L`)
 * Space Complexity:    O(`L`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Stack {
    private static final char PAREN_OPEN1 = '{';
    private static final char PAREN_OPEN2 = '[';
    private static final char PAREN_OPEN3 = '(';
    private static final char PAREN_CLOSED1 = '}';
    private static final char PAREN_CLOSED2 = ']';
    private static final char PAREN_CLOSED3 = ')';

    public boolean isValid(String s) {
        final int L = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        char[] chs = s.toCharArray();

        for (final char ch : chs) {
            switch (ch) {
                case PAREN_OPEN1:
                    stack.push(PAREN_CLOSED1);
                    break;
                case PAREN_OPEN2:
                    stack.push(PAREN_CLOSED2);
                    break;
                case PAREN_OPEN3:
                    stack.push(PAREN_CLOSED3);
                    break;
                default:
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != ch)
                        return false;
                    break;
            }
        }

        if (!stack.isEmpty())
            return false;

        return true;
    }
}
