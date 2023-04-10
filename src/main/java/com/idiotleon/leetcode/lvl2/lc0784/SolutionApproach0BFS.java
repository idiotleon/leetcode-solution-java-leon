package com.idiotleon.leetcode.lvl2.lc0784;

import com.idiotleon.util.Constant;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/letter-case-permutation/">LC0784</a>
 * <p>
 * Time Complexity:     O(L + 2 ^ letter(L))
 * L, length of S
 * letter(L), length of all letters of S
 * <p>
 * Space Complexity:    O(L + 2 ^ letter(L)) ~ O(2 ^ L)
 * L, length of S
 * letter(L), length of all letters of S
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/letter-case-permutation/discuss/656296/Java-Clean-Code-DFS-%2B-BFS">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    public List<String> letterCasePermutation(String S) {
        final List<String> ans = new ArrayList<>();
        // sanity check
        if (S == null || S.isEmpty()) return ans;

        final int L = S.length();
        char[] chs = S.toCharArray();
        final Deque<String> queue = new ArrayDeque<>();
        queue.addLast(S);

        for (int i = 0; i < L; i++) {
            if (chs[i] >= '0' && chs[i] <= '9') continue;

            for (int size = queue.size(); size > 0; size--) {
                final char[] cur = queue.removeFirst().toCharArray();

                final char ch = cur[i];

                cur[i] = Character.toLowerCase(ch);
                queue.addLast(String.valueOf(cur));

                cur[i] = Character.toUpperCase(ch);
                queue.addLast(String.valueOf(cur));
            }
        }

        return new ArrayList<>(queue);
    }
}