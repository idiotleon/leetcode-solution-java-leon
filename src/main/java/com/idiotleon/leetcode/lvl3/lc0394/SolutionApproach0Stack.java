/**
 * https://leetcode.com/problems/decode-string/
 * 
 * Time Complexity:     O(L) + O(max digit of `s`)
 * Space Complexity:    O(L) + O(max digit of `s`)
 * 
 * References:
 *  https://leetcode.com/problems/decode-string/discuss/87534/Simple-Java-Solution-using-Stack/92413
 *  https://leetcode.com/problems/decode-string/discuss/87534/Simple-Java-Solution-using-Stack
 */
package com.idiotleon.leetcode.lvl3.lc0394;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack {
    private static final char OPEN_SQUARE_BRACKET = '[';
    private static final char CLOSED_SQUARE_BRACKED = ']';

    public String decodeString(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return "";

        Deque<Integer> repetitiveTimes = new ArrayDeque<>();
        Deque<StringBuilder> stack = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();

        int repNum = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                repNum = repNum * 10 + ch - '0';
            } else if (ch == OPEN_SQUARE_BRACKET) {
                repetitiveTimes.push(repNum);
                stack.push(builder);
                builder = new StringBuilder();
                repNum = 0;
            } else if (ch == CLOSED_SQUARE_BRACKED) {
                StringBuilder subBuilder = builder;
                builder = stack.pop();
                int repeated = repetitiveTimes.pop();
                while (repeated-- > 0) {
                    builder.append(subBuilder);
                }
            } else {
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}