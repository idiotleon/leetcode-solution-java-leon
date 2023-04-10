package com.idiotleon.leetcode.lvl4.lc0227;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/basic-calculator-ii/">LC0227</a>
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Stack {
    public int calculate(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        final char[] chs = s.toCharArray();

        final Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char op = '+';

        for (int i = 0; i < L; ++i) {
            final char ch = chs[i];
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            }

            if ((!Character.isDigit(ch) && ' ' != ch) || i == L - 1) {
                switch (op) {
                    case '-':
                        stack.push(-num);
                        break;
                    case '+':
                        stack.push(num);
                        break;
                    case '*':
                        int multi = num * stack.pop();
                        stack.push(multi);
                        break;
                    case '/':
                        int div = stack.pop() / num;
                        stack.push(div);
                        break;
                    default:
                        break;
                }

                op = ch;
                num = 0;
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }
}