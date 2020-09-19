/**
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/generate-parentheses/discuss/10127/An-iterative-method.
 */
package com.zea7ot.leetcode.lvl2.lc0022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionApproach1DP1Dimen {
    private static final char OPEN_PAREN = '(';
    private static final char CLOSED_PAREN = ')';

    public List<String> generateParenthesis(int n) {
        if (n < 1)
            return new ArrayList<>();

        final List<List<String>> PATHS = new ArrayList<>();
        PATHS.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i) {
            final List<String> PATH = new ArrayList<>();

            for (int j = 0; j < i; ++j) {
                for (final String FIRST : PATHS.get(j)) {
                    for (final String SECOND : PATHS.get(i - 1 - j)) {
                        PATH.add(OPEN_PAREN + FIRST + CLOSED_PAREN + SECOND);
                    }
                }
            }

            PATHS.add(PATH);
        }

        return PATHS.get(PATHS.size() - 1);
    }
}
