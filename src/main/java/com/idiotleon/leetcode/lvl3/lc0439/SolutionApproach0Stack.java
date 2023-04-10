/**
 * https://leetcode.com/problems/ternary-expression-parser/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.idiotleon.leetcode.lvl3.lc0439;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack {
    public String parseTernary(String expression) {
        // sanity check
        if (expression == null || expression.isEmpty())
            return "";

        final int L = expression.length();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = L - 1; i >= 0; --i) {
            final char CH = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop(); // to pop out '?'
                final char LEFT = stack.pop();
                stack.pop(); // to pop out ':'
                final char RIGHT = stack.pop();

                if (CH == 'T')
                    stack.push(LEFT);
                else
                    stack.push(RIGHT);
            } else
                stack.push(CH);
        }

        return String.valueOf(stack.peek());
    }
}