/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/419402/JavaC%2B%2B-Stack
 */
package com.an7one.leetcode.lvl3.lc1249;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack {
    private static final char PLACE_HOLDER = '.';
    private static final char OPEN_PAREN = '(';
    private static final char CLOSED_PAREN = ')';

    public String minRemoveToMakeValid(String s) {
        // santiy check
        if (s == null || s.isEmpty())
            return "";

        final int L = s.length();
        final char[] CHS = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < L; ++i) {
            final char CH = CHS[i];
            if (CH == OPEN_PAREN)
                stack.offer(i);

            if (CH == CLOSED_PAREN) {
                if (stack.isEmpty()) {
                    CHS[i] = PLACE_HOLDER;
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty())
            CHS[stack.pop()] = PLACE_HOLDER;

        // to build up the answer
        StringBuilder builder = new StringBuilder();
        for (final char CH : CHS)
            if (CH != PLACE_HOLDER)
                builder.append(CH);

        return builder.toString();
    }
}