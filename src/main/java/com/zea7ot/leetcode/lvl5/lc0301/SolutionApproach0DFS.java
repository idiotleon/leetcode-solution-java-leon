/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 
 * Time Complexity:     O((OPEN_PAREN + CLOSED_PAREN) * (2 ^ (OPEN_PAREN + CLOSED_PAREN))) ~ O(L * (2 ^ L))
 * Space Complexity:    O((OPEN_PAREN + CLOSED_PAREN) ^ 2) ~ O(L ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution/113024
 *  https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution/156556
 *  https://zxi.mytechroad.com/blog/searching/leetcode-301-remove-invalid-parentheses/
 */
package com.zea7ot.leetcode.lvl5.lc0301;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS {
    private static final char OPEN = '(';
    private static final char CLOSED = ')';

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        // sanity check
        if (s == null)
            return ans;
        // when str.isEmpty(), [""] is expected to be returned, instead of []
        // if(str == null || str.isEmpty()) return ans;

        dfs(0, 0, s, OPEN, CLOSED, ans);
        return ans;
    }

    private void dfs(int loStart, int hiStart, String str, final char OPEN_PAREN, final char CLOSED_PAREN,
            List<String> res) {

        final int L = str.length();
        final char[] CHS = str.toCharArray();

        int stack = 0;
        for (int hi = hiStart; hi < L; ++hi) {
            if (CHS[hi] == OPEN_PAREN)
                ++stack;
            if (CHS[hi] == CLOSED_PAREN)
                --stack;
            if (stack >= 0)
                continue;

            for (int lo = loStart; lo <= hi; ++lo) {
                if (CHS[lo] == CLOSED_PAREN && (lo == loStart || CHS[lo - 1] != CLOSED_PAREN)) {
                    String deleted = new StringBuilder(str).deleteCharAt(lo).toString();
                    // or equivalently
                    // String deleted = str.substring(0, lo) + str.substring(lo + 1);
                    dfs(lo, hi, deleted, OPEN_PAREN, CLOSED_PAREN, res);
                }
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