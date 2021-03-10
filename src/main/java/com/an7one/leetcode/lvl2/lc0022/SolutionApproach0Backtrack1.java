/**
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * Time Complexity:     O(2 ^ (2 * `n`))
 * Space Complexity:    O(2 * `n`) ~ O(`n`)
 * 
 * References:
 *  https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
 *  https://leetcode.com/problems/generate-parentheses/discuss/10098/Java-DFS-way-solution/116003
 */
package com.an7one.leetcode.lvl2.lc0022;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    private static final char OPEN_PAREN = '(';
    private static final char CLOSED_PAREN = ')';

    public List<String> generateParenthesis(int n) {
        final List<String> PATHS = new ArrayList<>();
        if (n < 1)
            return PATHS;

        final String PATH = "";
        backtrack(PATH, 0, 0, n, PATHS);

        return PATHS;
    }

    private void backtrack(final String PATH, final int COUNT_OPEN, final int COUNT_CLOSED, final int N,
            List<String> ans) {
        if (PATH.length() == 2 * N) {
            ans.add(PATH);
            return;
        }

        if (COUNT_OPEN < N) {
            backtrack(PATH + OPEN_PAREN, COUNT_OPEN + 1, COUNT_CLOSED, N, ans);
        }

        if (COUNT_CLOSED < COUNT_OPEN) {
            backtrack(PATH + CLOSED_PAREN, COUNT_OPEN, COUNT_CLOSED + 1, N, ans);
        }
    }
}