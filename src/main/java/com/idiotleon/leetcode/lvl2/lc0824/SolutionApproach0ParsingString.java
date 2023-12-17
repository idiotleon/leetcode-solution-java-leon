package com.idiotleon.leetcode.lvl2.lc0824;

import com.idiotleon.util.Constant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/goat-latin/">LC0824</a>
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0ParsingString {
    public String toGoatLatin(final String S) {
        final Set<Character> VOWELS = new HashSet<>((Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')));

        final StringBuilder builder = new StringBuilder();
        int copies = 1;
        for (final String word : S.split(" ")) {
            final char first = word.charAt(0);
            if (VOWELS.contains(first)) {
                builder.append(word);
            } else {
                builder.append(word.substring(1));
                builder.append(first);
            }

            builder.append("ma");
            for (int i = 0; i < copies; ++i) {
                builder.append("a");
            }
            ++copies;
            builder.append(" ");
        }

        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}