/**
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl2.lc1190;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack {
    public String reverseParentheses(String s) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(builder.toString());
                // to clear the string builder
                builder.setLength(0);
            } else if (s.charAt(i) == ')') {
                builder.reverse();
                if (!stack.isEmpty()) {
                    builder.insert(0, stack.pop());
                }
            } else {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }
}