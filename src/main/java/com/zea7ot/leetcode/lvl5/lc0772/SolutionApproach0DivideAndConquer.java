/**
 * https://leetcode.com/problems/basic-calculator-iii/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) + O(NUM('(')) ~ O(L)
 * 
 * References:
 *  https://leetcode.com/problems/basic-calculator-iii/discuss/152092/O(n)-Java-Recursive-Simple-Solution/227715
 */
package com.zea7ot.leetcode.lvl5.lc0772;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0DivideAndConquer {
    private static final char SPACE = ' ';
    private static final char OPEN_PAREN = '(';
    private static final char CLOSED_PAREN = ')';

    public int calculate(String s) {
        // santiy check
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
        char op = '+';
        int num = 0, sum = 0, prev = 0;

        while (!tokensQ.isEmpty()) {
            final char CH = tokensQ.poll();

            if ('0' <= CH && CH <= '9') {
                num = num * 10 + CH - '0';
            } else if (CH == OPEN_PAREN) {
                num = calculate(tokensQ);
            } else {
                switch (op) {
                    case '+':
                        sum += prev;
                        prev = num;
                        break;
                    case '-':
                        sum += prev;
                        prev = -num;
                        break;
                    case '*':
                        prev *= num;
                        break;
                    case '/':
                        prev /= num;
                        break;
                }

                if (CH == CLOSED_PAREN)
                    break;
                op = CH;
                num = 0;
            }
        }

        return sum + prev;
    }
}