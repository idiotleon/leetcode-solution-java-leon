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
package com.zea7ot.leetcode.lvl5.lc0301;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS {
    public List<String> removeInvalidParentheses(String str) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if (str == null)
            return ans;
        // when str.isEmpty(), [""] is expected to be returned, instead of []
        // if(str == null || str.isEmpty()) return ans;

        dfs(0, 0, str, '(', ')', ans);
        return ans;
    }

    private void dfs(int iStart, int jStart, String str, final char OPEN_PAREN, final char CLOSED_PAREN,
            List<String> res) {
        final int L = str.length();
        int stack = 0;
        for (int i = iStart; i < L; ++i) {
            if (str.charAt(i) == OPEN_PAREN)
                ++stack;
            if (str.charAt(i) == CLOSED_PAREN)
                --stack;
            if (stack >= 0)
                continue;

            for (int j = jStart; j <= i; ++j) {
                if (str.charAt(j) == CLOSED_PAREN && (j == jStart || str.charAt(j - 1) != CLOSED_PAREN)) {
                    dfs(i, j, str.substring(0, j) + str.substring(j + 1), OPEN_PAREN, CLOSED_PAREN, res);
                }
            }

            return;
        }

        String reversed = new StringBuilder(str).reverse().toString();
        if (OPEN_PAREN == '(') {
            dfs(0, 0, reversed, ')', '(', res);
        } else {
            res.add(reversed);
        }
    }
}