package com.an7one.leetcode.lvl5.lc0224;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/basic-calculator/">LC0224</a>
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Stack {
    public int calculate(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        int ans = 0, sign = 1;
        // to keep track of the current number
        int num = 0;

        final Deque<Integer> stack = new ArrayDeque<>();
        stack.push(sign);

        for (int i = 0; i < L; ++i) {
            final char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else if (ch == '+' || ch == '-') {
                ans += sign * num;
                sign = stack.peek() * (ch == '+' ? 1 : -1);
                num = 0;
            } else if (ch == '(') {
                stack.push(sign);
            } else if (ch == ')') {
                stack.pop();
            }
        }

        ans += sign * num;
        return ans;
    }
}