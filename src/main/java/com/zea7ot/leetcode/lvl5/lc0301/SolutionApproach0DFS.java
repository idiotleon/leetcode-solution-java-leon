/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
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
        dfs(str, ans, 0, 0, '(', ')');
        return ans;
    }

    private void dfs(String str, List<String> ans, int iStart, int jStart, char openParen, char closedParen) {
        final int L = str.length();
        int stack = 0;
        for (int i = iStart; i < L; ++i) {
            if (str.charAt(i) == openParen)
                ++stack;
            if (str.charAt(i) == closedParen)
                --stack;
            if (stack >= 0)
                continue;

            for (int j = jStart; j <= i; j++) {
                if (str.charAt(j) == closedParen && (j == jStart || str.charAt(j - 1) != closedParen)) {
                    dfs(str.substring(0, j) + str.substring(j + 1), ans, i, j, openParen, closedParen);
                }
            }

            return;
        }

        String reversed = new StringBuilder(str).reverse().toString();
        if (openParen == '(') {
            dfs(reversed, ans, 0, 0, ')', '(');
        } else {
            ans.add(reversed);
        }
    }
}