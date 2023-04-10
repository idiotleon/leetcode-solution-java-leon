/**
 * https://leetcode.com/problems/basic-calculator-iii/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) + O(NUM('(')) ~ O(L)
 * 
 * References:
 *  https://leetcode.com/problems/basic-calculator-iii/discuss/152092/O(n)-Java-Recursive-Simple-Solution
 */
package com.idiotleon.leetcode.lvl5.lc0772;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0DivideAndConquer1 {
    private final char SPACE = ' ';

    public int calculate(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        Deque<Character> tokensQ = new ArrayDeque<>();
        for (final char CH : s.toCharArray()) {
            if (CH != SPACE)
                tokensQ.offer(CH);
        }

        tokensQ.offer('+');
        return calculate(tokensQ);
    }

    private int calculate(Deque<Character> tokensQ) {
        char sign = '+';
        int num = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while (!tokensQ.isEmpty()) {
            final char CH = tokensQ.poll();

            if (CH >= '0' && CH <= '9') {
                num = 10 * num + CH - '0';
            } else if (CH == '(')
                num = calculate(tokensQ);
            else {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    int multi = stack.pop() * num;
                    stack.push(multi);
                } else if (sign == '/') {
                    int div = stack.pop() / num;
                    stack.push(div);
                }

                num = 0;
                sign = CH;

                if (CH == ')')
                    break;
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}