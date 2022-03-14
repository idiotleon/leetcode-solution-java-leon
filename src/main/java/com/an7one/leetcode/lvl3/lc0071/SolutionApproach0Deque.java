package com.an7one.leetcode.lvl3.lc0071;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Leon
 * https://leetcode.com/problems/simplify-path/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 *
 * References:
 *  https://leetcode.com/problems/simplify-path/discuss/25686/Java-10-lines-solution-with-stack/168182
 *  https://leetcode.com/problems/simplify-path/discuss/25686/Java-10-lines-solution-with-stack
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Deque {
    public String simplifyPath(String path) {
        final Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));

        Deque<String> deque = new ArrayDeque<>();
        for (String str : path.split("/")) {
            // be careful with `deque.isEmpty()` scenario
            if (!deque.isEmpty() && str.equals(".."))
                deque.poll();
            // otherwise `if...else if...` might BOTH be valid
            else if (!skip.contains(str))
                deque.push(str);
        }
        if (deque.isEmpty())
            return "/";

        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append("/").append(deque.pollLast());
        }

        return builder.toString();
    }
}
