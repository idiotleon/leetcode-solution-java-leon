package com.idiotleon.leetcode.lvl3.lc0150;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">LC0150</a>
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Stack {
    private static final String SIGN_PLUS = "+";
    private static final String SIGN_MINUS = "-";
    private static final String SIGN_DIVIDE = "/";
    private static final String SIGN_MULTIPLE = "*";

    public int evalRPN(String[] tokens) {
        int a, b;

        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case SIGN_PLUS:
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a + b);
                    break;
                case SIGN_MINUS:
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case SIGN_DIVIDE:
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                case SIGN_MULTIPLE:
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a * b);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}