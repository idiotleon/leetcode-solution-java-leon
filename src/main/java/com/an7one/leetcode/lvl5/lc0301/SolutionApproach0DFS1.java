/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 
 * Time Complexity:     O(2 ^ (OPEN_PAREN + CLOSED_PAREN))
 * Space Complexity:    O((OPEN_PAREN + CLOSED_PAREN) ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution/156556
 *  https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution/147484
 *  https://zxi.mytechroad.com/blog/searching/leetcode-301-remove-invalid-parentheses/
 */
package com.an7one.leetcode.lvl5.lc0301;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS1 {
    public List<String> removeInvalidparent(String s) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if (s == null)
            return ans;

        dfs(0, 0, s, new char[] { '(', ')' }, ans);
        return ans;
    }

    private void dfs(int iLast, int jLast, String str, char[] paren, List<String> res) {
        final int L = str.length();
        for (int stack = 0, i = iLast; i < L; ++i) {
            if (str.charAt(i) == paren[0])
                stack++;
            if (str.charAt(i) == paren[1])
                stack--;
            if (stack >= 0)
                continue;

            for (int j = jLast; j <= i; ++j) {
                if (str.charAt(j) == paren[1] && (j == jLast || str.charAt(j - 1) != paren[1])) {
                    dfs(i, j, str.substring(0, j) + str.substring(j + 1), paren, res);
                }
            }

            return;
        }

        String reversed = new StringBuilder(str).reverse().toString();
        if (paren[0] == '(') {
            dfs(0, 0, reversed, new char[] { ')', '(' }, res);
        } else {
            res.add(reversed);
        }
    }
}