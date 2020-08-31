/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/419402/JavaC%2B%2B-Stack
 */
package com.zea7ot.leetcode.lvl3.lc1249;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack {
    private static final char PLACE_HOLDER = '.';

    public String minRemoveToMakeValid(String s) {
        // santiy check
        if (s == null || s.isEmpty())
            return "";

        final int L = s.length();
        final char[] CHS = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < L; ++i) {
            char ch = CHS[i];
            if (ch == '(')
                stack.offer(i);

            if (ch == ')') {
                if (stack.isEmpty()) {
                    CHS[i] = PLACE_HOLDER;
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty())
            CHS[stack.pop()] = PLACE_HOLDER;

        return new String(CHS).replaceAll(String.valueOf(PLACE_HOLDER), "");
    }
}