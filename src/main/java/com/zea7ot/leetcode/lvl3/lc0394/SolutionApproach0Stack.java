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
package com.zea7ot.leetcode.lvl3.lc0394;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack {
    public String decodeString(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return "";

        Deque<Integer> times = new ArrayDeque<>();
        Deque<StringBuilder> stack = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();

        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                times.push(k);
                stack.push(builder);
                builder = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder temp = builder;
                builder = stack.pop();
                int repeated = times.pop();
                while (repeated-- > 0)
                    builder.append(temp);
            } else
                builder.append(ch);
        }

        return builder.toString();
    }
}