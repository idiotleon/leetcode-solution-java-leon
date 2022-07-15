package com.an7one.leetcode.lvl4.lc0227;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/basic-calculator-ii/">LC0227</a>
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Stack1 {
    private final Set<Character> OPERATORS = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

    public int calculate(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        s = "+" + s.trim();
        final int L = s.length();
        final char[] chs = s.toCharArray();

        final Deque<Integer> stack = new ArrayDeque<>();

        int lo = 0, hi = 1;
        while (hi < L) {
            final StringBuilder builder = new StringBuilder();
            while (hi < L && !OPERATORS.contains(chs[hi])) {
                if (chs[hi] == ' ') {
                    ++hi;
                    continue;
                }

                builder.append(chs[hi]);
                ++hi;
            }

            int num = Integer.parseInt(builder.toString());

            switch (chs[lo]) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
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

            lo = hi;
            ++hi;
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }
}
