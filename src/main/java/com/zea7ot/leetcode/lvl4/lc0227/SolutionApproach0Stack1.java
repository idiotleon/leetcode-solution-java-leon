/**
 * @author: Leon
 * https://leetcode.com/problems/basic-calculator-ii/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L)
 */
package com.zea7ot.leetcode.lvl4.lc0227;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Stack1 {
    private final Set<Character> OPERATORS = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

    public int calculate(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        s = "+" + s.trim();
        final int L = s.length();
        final char[] CHS = s.toCharArray();

        Deque<Integer> stack = new ArrayDeque<>();

        int lo = 0, hi = 1;
        while (hi < L) {
            StringBuilder builder = new StringBuilder();
            while (hi < L && !OPERATORS.contains(CHS[hi])) {
                if (CHS[hi] == ' ') {
                    ++hi;
                    continue;
                }

                builder.append(CHS[hi]);
                ++hi;
            }

            int num = Integer.parseInt(builder.toString());

            switch (CHS[lo]) {
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
