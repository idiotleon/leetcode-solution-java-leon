/**
 * @author: Leon
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * Time Complexity:     O(max(`LEN_S`, `LEN_T`))
 * Space Complexity:    O(max(`LEN_S`, `LEN_T`))
 */
package com.an7one.leetcode.lvl2.lc0844;

public class SolutionApproach0TwoPointers {
    private static final char ESCAPE = '#';

    public boolean backspaceCompare(String S, String T) {
        // not used
        // final int LEN_S = S.length(), LEN_T = T.length();
        return parse(S).equals(parse(T));
    }

    private String parse(String str) {
        StringBuilder builder = new StringBuilder();
        for (final char CH : str.toCharArray()) {
            if (CH == ESCAPE) {
                if (builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            } else
                builder.append(CH);
        }

        return builder.toString();
    }
}
