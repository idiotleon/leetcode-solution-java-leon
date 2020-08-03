/**
 * https://leetcode.com/problems/longest-absolute-file-path/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(NUM("\t"))
 * 
 * References:
 *  https://leetcode.com/problems/longest-absolute-file-path/discuss/86615/9-lines-4ms-Java-solution
 */
package com.zea7ot.lc.lvl3.lc0388;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0ParsingString1 {
    public int lengthLongestPath(String input) {
        // sanity check
        if (input == null || input.isEmpty())
            return 0;

        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        int maxLen = 0;
        for (String str : input.split("\n")) {
            final int L = str.length();
            final int SIZE = stack.size();
            //
            int idx = str.lastIndexOf("\t") + 1;
            // to find the parent
            while (idx + 1 < SIZE)
                stack.pop();
            // to remove "/t", and add "/"
            final int LEN = stack.peek() + L - idx + 1;
            stack.push(LEN);
            if (str.contains("."))
                maxLen = Math.max(maxLen, LEN - 1);
        }

        return maxLen;
    }
}