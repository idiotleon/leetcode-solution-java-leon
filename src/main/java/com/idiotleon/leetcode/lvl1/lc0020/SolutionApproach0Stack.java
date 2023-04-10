package com.idiotleon.leetcode.lvl1.lc0020;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/valid-parentheses/">LC0020</a>
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
        final Deque<Character> stack = new ArrayDeque<>();
        final char[] chs = s.toCharArray();

        for (final char ch : chs) {
            switch (ch) {
                case PAREN_OPEN1:
                    stack.addLast(PAREN_CLOSED1);
                    break;
                case PAREN_OPEN2:
                    stack.addLast(PAREN_CLOSED2);
                    break;
                case PAREN_OPEN3:
                    stack.addLast(PAREN_CLOSED3);
                    break;
                default:
                    if (stack.isEmpty())
                        return false;
                    if (stack.removeLast() != ch)
                        return false;
                    break;
            }
        }

        return stack.isEmpty();
    }
}
