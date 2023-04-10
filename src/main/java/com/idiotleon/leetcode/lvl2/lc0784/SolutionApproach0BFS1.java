package com.idiotleon.leetcode.lvl2.lc0784;

import com.idiotleon.util.Constant;

import java.util.*;

/**
 * @author: Leon
 * https://leetcode.com/problems/letter-case-permutation/
 * <p>
 * Time Complexity:     O(digit(L) + 2 ^ letter(L)) ~ O(2 ^ L)
 * L, the length of the String S
 * <p>
 * Space Complexity:    O(2 ^ letter(L))
 * L, the length of the String S
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS1 {
    public List<String> letterCasePermutation(String S) {
        final List<String> ans = new ArrayList<>();
        // sanity check
        if (S == null || S.isEmpty()) return ans;

        final char[] chs = S.toCharArray();
        int idx = 0;

        final Deque<StringBuilder> queue = new ArrayDeque<>();
        queue.addLast(new StringBuilder());

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();
            final char ch = chs[idx];

            for (int j = 0; j < SIZE; ++j) {
                final StringBuilder cur = queue.poll();

                if (ch >= '0' && ch <= '9') {
                    cur.append(ch);
                    queue.addLast(cur);
                } else {
                    final StringBuilder transform = new StringBuilder(cur);
                    cur.append(Character.toUpperCase(ch));
                    queue.addLast(cur);
                    transform.append(Character.toLowerCase(ch));
                    queue.addLast(transform);
                }
            }

            ++idx;
            if (idx == chs.length) break;
        }

        while (!queue.isEmpty()) ans.add(queue.removeFirst().toString());

        return ans;
    }
}