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
 * <a href="https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution/156556">LCDiscussion</a>
 * <a href="https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution/147484">LCDiscussion</a>
 * <a href="https://zxi.mytechroad.com/blog/searching/leetcode-301-remove-invalid-parentheses/">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFS1 {
    public List<String> removeInvalidParentheses(String s) {
        final List<String> ans = new ArrayList<>();
        // sanity check
        if (s == null) {
            return ans;
        }

        dfs(0, 0, s, new char[]{'(', ')'}, ans);
        return ans;
    }

    private void dfs(int iLast, int jLast, String str, char[] paren, List<String> res) {
        final int L = str.length();
        for (int stack = 0, i = iLast; i < L; ++i) {
            if (str.charAt(i) == paren[0]) {
                ++stack;
            }
            if (str.charAt(i) == paren[1]) {
                --stack;
            }
            if (stack >= 0) {
                continue;
            }

            for (int j = jLast; j <= i; ++j) {
                if (str.charAt(j) == paren[1] && (j == jLast || str.charAt(j - 1) != paren[1])) {
                    dfs(i, j, str.substring(0, j) + str.substring(j + 1), paren, res);
                }
            }

            return;
        }

        String reversed = new StringBuilder(str).reverse().toString();
        if (paren[0] == '(') {
            dfs(0, 0, reversed, new char[]{')', '('}, res);
        } else {
            res.add(reversed);
        }
    }
}