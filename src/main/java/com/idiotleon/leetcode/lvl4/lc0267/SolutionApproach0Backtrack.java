package com.idiotleon.leetcode.lvl4.lc0267;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/palindrome-permutation-ii/">LC0267</a>
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/palindrome-permutation-ii/discuss/69698/Short-backtracking-solution-in-Java-(3-ms)">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Backtrack {
    public List<String> generatePalindromes(String s) {
        final List<String> ans = new ArrayList<>();
        // sanity check
        if (s == null || s.isEmpty()) {
            return ans;
        }

        final int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            ++freq[c];
        }

        int oddCount = 0, halfLen = 0;
        char oddChar = 0;   // an impossible char
        for (int i = 0; i < 128; ++i) {
            if (freq[i] % 2 == 1) {
                ++oddCount;
                oddChar = (char) i;
            }

            freq[i] /= 2;
            halfLen += freq[i];
        }

        // cannot tolerate more than one chars of the odd number
        if (oddCount > 1) {
            return ans;
        }

        backtrack(freq, new StringBuilder(), ans, halfLen, oddChar);

        return ans;
    }

    private void backtrack(final int[] freq, final StringBuilder path, final List<String> paths, final int halfLen, final char midChar) {
        if (path.length() == halfLen) {
            final StringBuilder builder = new StringBuilder(path);
            if (midChar != 0) {
                builder.append(midChar);
            }
            final StringBuilder reverse = new StringBuilder(path).reverse();
            builder.append(reverse);
            paths.add(builder.toString());
            return;
        }

        for (int i = 0; i < 128; ++i) {
            if (freq[i] > 0) {
                --freq[i];
                path.append((char) i);
                backtrack(freq, path, paths, halfLen, midChar);
                path.deleteCharAt(path.length() - 1);
                ++freq[i];
            }
        }
    }
}