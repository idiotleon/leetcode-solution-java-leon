package com.zea7ot.leetcode.lvl3.lc0484;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach1MonoStack1 {
    private static final char DECREASING = 'D';

    public int[] findPermutation(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return new int[0];

        final int L = s.length();
        int[] ans = new int[L + 1];
        char[] chs = s.toCharArray();

        Deque<Integer> stack = new ArrayDeque<Integer>();
        int idx = 0;
        for (int i = 1; i <= L; ++i) {
            if (chs[i - 1] == DECREASING)
                stack.push(i);
            else {
                stack.push(i);
                while (!stack.isEmpty())
                    ans[idx++] = stack.pop();
            }
        }

        stack.push(L + 1);
        while (!stack.isEmpty())
            ans[idx++] = stack.pop();

        return ans;
    }
}