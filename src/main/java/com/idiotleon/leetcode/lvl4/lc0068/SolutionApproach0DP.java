package com.idiotleon.leetcode.lvl4.lc0068;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/text-justification/">LC0068</a>
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP {
    public List<String> fullJustify(String[] words, int maxWidth) {
        final List<String> lines = new ArrayList<>();
        // sanity check
        if (words == null || words.length == 0 || maxWidth <= 0) {
            return lines;
        }

        final int L = words.length;
        int idx = 0;
        while (idx < L) {
            int count = words[idx].length();
            int last = idx + 1;
            while (last < L) {
                if (words[last].length() + count + 1 > maxWidth) {
                    break;
                }
                count += words[last].length() + 1;
                ++last;
            }

            final StringBuilder builder = new StringBuilder();
            final int diff = last - idx - 1;

            if (last == L || diff == 0) {
                for (int i = idx; i < last; i++) {
                    builder.append(words[i]).append(" ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            } else {
                final int spaces = (maxWidth - count) / diff;
                final int r = (maxWidth - count) % diff;
                for (int i = idx; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - idx) < r ? 1 : 0)); ++i) {
                            builder.append(" ");
                        }
                    }
                }
            }

            lines.add(builder.toString());
            idx = last;
        }

        return lines;
    }
}