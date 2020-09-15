/**
 * https://leetcode.com/problems/basic-calculator-ii/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L)
 */
package com.zea7ot.leetcode.lvl4.lc0227;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack {
    public int calculate(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char op = '+';

        for (int i = 0; i < L; ++i) {
            final char CH = CHS[i];
            if (CH >= '0' && CH <= '9') {
                num = num * 10 + CH - '0';
            }

            if ((!Character.isDigit(CH) && ' ' != CH) || i == L - 1) {
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

                op = CH;
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