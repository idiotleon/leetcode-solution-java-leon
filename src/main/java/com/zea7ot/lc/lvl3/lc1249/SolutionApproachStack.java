/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/419402/JavaC%2B%2B-Stack
 */
package com.zea7ot.lc.lvl3.lc1249;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproachStack {
    private static final char PLACE_HOLDER = '*';

    public String minRemoveToMakeValid(String s) {
        final int L = s.length();
        char[] chs = s.toCharArray();
        StringBuilder builder = new StringBuilder(s);
        Deque<Integer> idxStack = new ArrayDeque<Integer>();

        for (int i = 0; i < L; ++i) {
            char ch = chs[i];
            if (ch == '(')
                idxStack.offer(i);

            if (ch == ')') {
                if (idxStack.isEmpty()) {
                    builder.setCharAt(i, PLACE_HOLDER);
                } else {
                    idxStack.pop();
                }
            }
        }

        while (!idxStack.isEmpty()) {
            builder.setCharAt(idxStack.pop(), PLACE_HOLDER);
        }

        return builder.toString().replaceAll("\\*", "");
    }
}