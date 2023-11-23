package com.idiotleon.leetcode.lvl5.lc0301;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/remove-invalid-parentheses/">LC0301</a>
 * <p>
 * Time Complexity:     O(2 ^ (OPEN_PAREN + CLOSED_PAREN))
 * Space Complexity:    O((OPEN_PAREN + CLOSED_PAREN) ^ 2)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution">LCDiscussion</a>
 * <a href="https://zxi.mytechroad.com/blog/searching/leetcode-301-remove-invalid-parentheses/">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFS2 {
    public List<String> removeInvalidParentheses(String s) {
        final List<String> ans = new ArrayList<>();
        // sanity check
        if (s == null) return ans;

        dfs(0, 0, s, '(', ')', ans);
        return ans;
    }

    private void dfs(int iStart, int jStart, String str, final char OPEN_PAREN, final char CLOSED_PAREN, List<String> res) {
        final int L = str.length();
        int numOpenParen = 0, numClosedParen = 0;

        for (int i = iStart; i < L; ++i) {
            if (str.charAt(i) == OPEN_PAREN) {
                ++numOpenParen;
            }
            if (str.charAt(i) == CLOSED_PAREN) {
                ++numClosedParen;
            }
            if (numClosedParen > numOpenParen) { // there is an extra closed parentheses to remove
                for (int j = jStart; j <= i; ++j) { // to remove one at each position, skipping duplicates
                    if (str.charAt(j) == CLOSED_PAREN && (j == jStart || str.charAt(j - 1) != CLOSED_PAREN)) {
                        // Recursion: iStart = i since we now have valid # closed parenthesis through i.
                        // jStart = j prevents duplicates
                        dfs(i, j, str.substring(0, j) + str.substring(j + 1), OPEN_PAREN, CLOSED_PAREN, res);
                    }
                }

                return;
            }
        }

        // to check the opposite direction, since no invalid parenthesis can be detected
        final String reversed = new StringBuilder(str).reverse().toString();
        if (OPEN_PAREN == '(') {
            dfs(0, 0, reversed, ')', '(', res);
        } else {
            res.add(reversed);
        }
    }
}