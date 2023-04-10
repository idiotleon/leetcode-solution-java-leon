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
package com.idiotleon.leetcode.lvl2.lc0022;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    private static final char OPEN_PAREN = '(';
    private static final char CLOSED_PAREN = ')';

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        // sanity check
        if (n < 1)
            return ans;

        StringBuilder builder = new StringBuilder();
        backtrack(builder, 0, 0, n, ans);

        return ans;
    }

    private void backtrack(StringBuilder builder, final int COUNT_OPEN, final int COUNT_CLOSED, final int N,
            List<String> ans) {

        if (builder.length() == 2 * N) {
            ans.add(builder.toString());
            return;
        }

        if (COUNT_OPEN < N) {
            builder.append(OPEN_PAREN);
            backtrack(builder, COUNT_OPEN + 1, COUNT_CLOSED, N, ans);
            builder.deleteCharAt(builder.length() - 1);
        }

        if (COUNT_CLOSED < COUNT_OPEN) {
            builder.append(CLOSED_PAREN);
            backtrack(builder, COUNT_OPEN, COUNT_CLOSED + 1, N, ans);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}