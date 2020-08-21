/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 
 * Time Complexity:     O(2 ^ (OPEN_PAREN + CLOSED_PAREN))
 * Space Complexity:    O((OPEN_PAREN + CLOSED_PAREN) ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution/156556
 *  https://zxi.mytechroad.com/blog/searching/leetcode-301-remove-invalid-parentheses/
 */
package com.zea7ot.leetcode.lvl4.lc0301;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS {
    private static final char OPEN = '(';
    private static final char CLOSED = ')';

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null)
            return ans;
        // when str.isEmpty(), [""] is expected to be returned, instead of []
        // if(str == null || str.isEmpty()) return ans;

        dfs(0, 0, s, OPEN, CLOSED, ans);
        return ans;
    }

    private void dfs(int iStart, int jStart, String str, final char OPEN_PAREN, final char CLOSED_PAREN,
            List<String> res) {

        final int L = str.length();
        char[] chs = str.toCharArray();

        int stack = 0;
        for (int i = iStart; i < L; ++i) {
            if (chs[i] == OPEN_PAREN)
                ++stack;
            if (chs[i] == CLOSED_PAREN)
                --stack;
            if (stack >= 0)
                continue;

            for (int j = jStart; j <= i; ++j) {
                if (chs[j] == CLOSED_PAREN && (j == jStart || chs[j - 1] != CLOSED_PAREN))
                    dfs(i, j, str.substring(0, j) + str.substring(j + 1), OPEN_PAREN, CLOSED_PAREN, res);
            }

            return;
        }

        String reversed = new StringBuilder(str).reverse().toString();
        if (OPEN_PAREN == OPEN) {
            dfs(0, 0, reversed, CLOSED, OPEN, res);
        } else {
            res.add(reversed);
        }
    }
}