/**
 * https://leetcode.com/problems/goat-latin/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.an7one.leetcode.lvl2.lc0824;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0ParsingString {
    public String toGoatLatin(String S) {
        final Set<Character> VOWELS = new HashSet<Character>(
                (Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')));

        StringBuilder builder = new StringBuilder();
        int copies = 1;
        for (String word : S.split(" ")) {
            char first = word.charAt(0);
            if (VOWELS.contains(first))
                builder.append(word);
            else {
                builder.append(word.substring(1));
                builder.append(first);
            }

            builder.append("ma");
            for (int i = 0; i < copies; ++i)
                builder.append("a");
            ++copies;
            builder.append(" ");
        }

        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}