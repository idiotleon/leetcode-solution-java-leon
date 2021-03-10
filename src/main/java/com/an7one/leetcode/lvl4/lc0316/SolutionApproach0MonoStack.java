/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * to main a "strickly increasing" stack
 *  1. the contents are actual characters
 *  2. the order of characters is maintained in strictly increasing order, if possible 
 *      by "if possible", it rather depends on the given String sequence,
 *      in another words, how many letters left, and what they are
 * 
 * the same problem:
 *  https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */
package com.an7one.leetcode.lvl4.lc0316;

public class SolutionApproach0MonoStack {
    public String removeDuplicateLetters(String s) {
        // to count the remaining alphabet letters
        int[] remaining = new int[26];
        // to count the alphabet letters used in the string
        int[] used = new int[26];

        final char[] CHS = s.toCharArray();

        final int L = s.length();
        for (int i = 0; i < L; ++i) {
            ++remaining[CHS[i] - 'a'];
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < L; ++i) {
            if (used[CHS[i] - 'a'] == 0) {
                // to pop out duplicates and bigger characters existing in the builder
                while (builder.length() > 0 && builder.charAt(builder.length() - 1) >= CHS[i]
                        && remaining[builder.charAt(builder.length() - 1) - 'a'] > 0) {

                    --used[builder.charAt(builder.length() - 1) - 'a'];
                    builder.deleteCharAt(builder.length() - 1);
                }

                builder.append(CHS[i]);
                ++used[CHS[i] - 'a'];
            }

            --remaining[CHS[i] - 'a'];
        }

        return builder.toString();
    }
}