/**
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/generate-parentheses/discuss/10127/An-iterative-method./126848
 *  https://leetcode.com/problems/generate-parentheses/discuss/10098/Java-DFS-way-solution/116003
 */
package com.an7one.leetcode.lvl2.lc0022;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach1DFSMemo {
    private static final char OPEN_PAREN = '(';
    private static final char CLOSED_PAREN = ')';

    public List<String> generateParenthesis(int n) {
        final List<String> PATHS = new ArrayList<>();
        if (n == 0)
            PATHS.add("");
        else {
            for (int i = 0; i < n; ++i) {
                for (final String OPEN : generateParenthesis(i)) {
                    for (final String CLOSED : generateParenthesis(n - i - 1)) {
                        PATHS.add(OPEN_PAREN + OPEN + CLOSED_PAREN + CLOSED);
                    }
                }
            }
        }

        return PATHS;
    }
}
