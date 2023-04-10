/**
 * https://leetcode.com/problems/decode-string/
 * 
 * Time Complexity:     O(L) + O(max digit of `s`)
 * Space Complexity:    O(L) + O(max digit of `s`)
 * 
 * References:
 *  https://leetcode.com/problems/decode-string/discuss/210284/Java-Recursive
 */
package com.idiotleon.leetcode.lvl3.lc0394;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0DFSRecursive {
    private static final char OPEN_SQUARE_BRACKET = '[';
    private static final char CLOSED_SQUARE_BRACKED = ']';

    public String decodeString(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return "";

        Deque<Character> queue = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            queue.offer(ch);
        }

        return dfs(queue);
    }

    private String dfs(Deque<Character> queue) {
        StringBuilder builder = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            final char CH = queue.poll();
            if (Character.isDigit(CH)) {
                num = num * 10 + CH - '0';
            } else if (CH == OPEN_SQUARE_BRACKET) {
                String sub = dfs(queue);
                for (int i = 0; i < num; ++i) {
                    builder.append(sub);
                }

                num = 0;
            } else if (CH == CLOSED_SQUARE_BRACKED)
                break;
            else {
                builder.append(CH);
            }
        }

        return builder.toString();
    }
}