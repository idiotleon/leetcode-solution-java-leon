/**
 * https://leetcode.com/problems/simplify-path/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.zea7ot.leetcode.lvl3.lc0071;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack {
    public String simplifyPath(String path) {
        // sanity check
        if (path == null || path.isEmpty())
            return path;

        String[] splitted = path.split("/", -1);
        Deque<String> stack = new ArrayDeque<String>();

        for (String str : splitted) {
            if (str.trim().isEmpty())
                continue;

            if (str.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();

                continue;
            }

            if (!str.equals("."))
                stack.push(str);
        }

        if (stack.isEmpty())
            return "/";

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            String top = stack.pop();
            builder.insert(0, "/" + top);
        }

        // equivalently
        // while (!stack.isEmpty()) {
        //     String last = stack.removeLast();
        //     builder.append("/" + last);
        // }

        return builder.toString();
    }
}