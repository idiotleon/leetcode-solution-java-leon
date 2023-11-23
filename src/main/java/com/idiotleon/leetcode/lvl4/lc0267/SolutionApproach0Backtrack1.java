package com.idiotleon.leetcode.lvl4.lc0267;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindrome-permutation-ii/">LC0267</a>
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Backtrack1 {
    private static final char IMPOSSIBLE = '#';

    public List<String> generatePalindromes(String s) {
        final List<String> ans = new ArrayList<>();
        // sanity check
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }

        final int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            ++freq[c];
        }

        final StringBuilder candidates = new StringBuilder();

        int oddCount = 0;
        char oddChar = IMPOSSIBLE;   // impossible char
        for (int i = 0; i < 128; i++) {
            if (freq[i] % 2 == 1) {
                oddCount++;
                oddChar = (char) i;
            }

            int cnt = freq[i] / 2;
            while (cnt-- > 0) {
                candidates.append((char) i);
            }
        }

        // cannot tolerate more than one char of odd number
        if (oddCount > 1) {
            return ans;
        }

        backtrack(candidates.toString().toCharArray(), new boolean[candidates.length()], new StringBuilder(), ans, oddChar);

        return ans;
    }

    private void backtrack(final char[] chs, final boolean[] visited, final StringBuilder path, final List<String> paths, final char oddChar) {
        final int L = chs.length;
        if (path.length() == L) {
            if (oddChar != IMPOSSIBLE) {
                paths.add(new StringBuilder(path).append(oddChar).append(new StringBuilder(path).reverse()).toString());
            } else {
                paths.add(new StringBuilder(path).append(new StringBuilder(path).reverse()).toString());
            }
            return;
        }

        for (int i = 0; i < chs.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && chs[i - 1] == chs[i] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            path.append(chs[i]);
            backtrack(chs, visited, path, paths, oddChar);
            visited[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }
}