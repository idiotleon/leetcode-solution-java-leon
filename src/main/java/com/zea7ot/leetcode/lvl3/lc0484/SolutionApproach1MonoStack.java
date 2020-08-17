/**
 * https://leetcode.com/problems/find-permutation/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * to pad the `s` with an 'I' at the tail
 * 
 * References:
 *  https://leetcode.com/problems/find-permutation/solution/657062
 */
package com.zea7ot.leetcode.lvl3.lc0484;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach1MonoStack {
    private static final char DECREASING = 'D';

    public int[] findPermutation(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return new int[0];

        s += 'I';
        final int L = s.length();
        char[] chs = s.toCharArray();
        int[] ans = new int[L];
        int idx = 0;

        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 1; i <= L; ++i) {
            if (chs[i - 1] == DECREASING)
                stack.push(i);
            else {
                ans[idx++] = i;
                while (!stack.isEmpty())
                    ans[idx++] = stack.pop();
            }
        }

        return ans;
    }
}