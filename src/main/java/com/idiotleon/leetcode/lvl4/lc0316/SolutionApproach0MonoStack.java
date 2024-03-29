package com.idiotleon.leetcode.lvl4.lc0316;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 *
 * to main a "strickly increasing" stack
 *  1. the contents are actual characters
 *  2. the order of characters is maintained in strictly increasing order, if possible
 *      by "if possible", it rather depends on the given String sequence,
 *      in other words, how many letters left, and what they are
 *
 * the same problem:
 *  https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MonoStack {
    public String removeDuplicateLetters(String s) {
        // to count the remaining alphabet letters
        final int[] remaining = new int[26];
        // to count the alphabet letters used in the string
        final int[] used = new int[26];

        final char[] chs = s.toCharArray();

        final int L = s.length();
        for (int i = 0; i < L; ++i) {
            ++remaining[chs[i] - 'a'];
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < L; ++i) {
            if (used[chs[i] - 'a'] == 0) {
                // to pop out duplicates and bigger characters existing in the builder
                while (builder.length() > 0 && builder.charAt(builder.length() - 1) >= chs[i]
                        && remaining[builder.charAt(builder.length() - 1) - 'a'] > 0) {

                    --used[builder.charAt(builder.length() - 1) - 'a'];
                    builder.deleteCharAt(builder.length() - 1);
                }

                builder.append(chs[i]);
                ++used[chs[i] - 'a'];
            }

            --remaining[chs[i] - 'a'];
        }

        return builder.toString();
    }
}