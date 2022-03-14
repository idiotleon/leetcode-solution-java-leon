package com.an7one.leetcode.lvl3.lc0071;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Leon
 * https://leetcode.com/problems/simplify-path/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Stack1 {
    public String simplifyPath(String path) {
        // sanity check
        if (path == null || path.isEmpty())
            return path;

        String[] splitted = path.split("/", -1);
        Deque<String> stack = new ArrayDeque<>();

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
        // String last = stack.removeLast();
        // builder.append("/" + last);
        // }

        return builder.toString();
    }
}