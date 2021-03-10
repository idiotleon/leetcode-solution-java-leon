/**
 * https://leetcode.com/problems/basic-calculator/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.an7one.leetcode.lvl5.lc0224;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack {
    public int calculate(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        int ans = 0, sign = 1;
        // to keep track of the current number
        int num = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(sign);

        for (int i = 0; i < L; ++i) {
            final char CH = s.charAt(i);

            if (CH >= '0' && CH <= '9') {
                num = num * 10 + (CH - '0');
            } else if (CH == '+' || CH == '-') {
                ans += sign * num;
                sign = stack.peek() * (CH == '+' ? 1 : -1);
                num = 0;
            } else if (CH == '(') {
                stack.push(sign);
            } else if (CH == ')') {
                stack.pop();
            }
        }

        ans += sign * num;
        return ans;
    }
}