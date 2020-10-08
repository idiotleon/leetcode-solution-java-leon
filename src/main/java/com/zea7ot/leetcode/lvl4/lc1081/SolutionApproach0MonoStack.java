/**
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * the same problem:
 *  https://leetcode.com/problems/remove-duplicate-letters/
 */
package com.zea7ot.leetcode.lvl4.lc1081;

public class SolutionApproach0MonoStack {
    public String smallestSubsequence(String text) {
        // to count remaining character
        int[] remaining = new int[26];
        // to count characters used in the string
        int[] used = new int[26];

        final int L = text.length();
        for (int i = 0; i < L; i++) {
            ++remaining[text.charAt(i) - 'a'];
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < L; i++) {
            if (used[text.charAt(i) - 'a'] == 0) {
                // to pop out duplicates and bigger characters
                while (builder.length() > 0 && builder.charAt(builder.length() - 1) >= text.charAt(i)
                        && remaining[builder.charAt(builder.length() - 1) - 'a'] > 0) {

                    --used[builder.charAt(builder.length() - 1) - 'a'];
                    builder.deleteCharAt(builder.length() - 1);
                }

                builder.append(text.charAt(i));
                ++used[text.charAt(i) - 'a'];
            }

            --remaining[text.charAt(i) - 'a'];
        }

        return builder.toString();
    }
}