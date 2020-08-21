/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 
 * Time Complexity:     O(2 ^ (OPEN_PAREN + CLOSED_PAREN))
 * Space Complexity:    O((OPEN_PAREN + CLOSED_PAREN) ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
 *  https://zxi.mytechroad.com/blog/searching/leetcode-301-remove-invalid-parentheses/
 */
package com.zea7ot.leetcode.lvl4.lc0301;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS2 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if (s == null)
            return ans;

        dfs(0, 0, s, '(', ')', ans);
        return ans;
    }

    private void dfs(int iStart, int jStart, String str, final char OPEN_PAREN, final char CLOSED_PAREN,
            List<String> res) {
        final int L = str.length();
        int numOpenParen = 0, numClosedParen = 0;

        for (int i = iStart; i < L; ++i) {
            if (str.charAt(i) == OPEN_PAREN)
                numOpenParen++;
            if (str.charAt(i) == CLOSED_PAREN)
                numClosedParen++;
            if (numClosedParen > numOpenParen) { // there is an extra closed parenthese to remove
                for (int j = jStart; j <= i; ++j) { // to remove one at each position, skipping duplicates
                    if (str.charAt(j) == CLOSED_PAREN && (j == jStart || str.charAt(j - 1) != CLOSED_PAREN)) {
                        // Recursion: iStart = i since we now have valid # closed parenthesis thru i.
                        // jStart = j prevents duplicates
                        dfs(i, j, str.substring(0, j) + str.substring(j + 1), OPEN_PAREN, CLOSED_PAREN, res);
                    }
                }

                return;
            }
        }

        // to check the opposite direction, since no invalid parenthesis can be detected
        String reversed = new StringBuilder(str).reverse().toString();
        if (OPEN_PAREN == '(') {
            dfs(0, 0, reversed, ')', '(', res);
        } else {
            res.add(reversed);
        }
    }
}