package com.idiotleon.leetcode.lvl5.lc0301;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/remove-invalid-parentheses/">LC0301</a>
 * <p>
 * Time Complexity:     O((OPEN_PAREN + CLOSED_PAREN) * (2 ^ (OPEN_PAREN + CLOSED_PAREN))) ~ O(L * (2 ^ L))
 * Space Complexity:    O((OPEN_PAREN + CLOSED_PAREN) ^ 2) ~ O(L ^ 2)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution/113024">LCDiscussion</a>
 * <a href="https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution/156556">LCDiscussion</a>
 * <a href="https://zxi.mytechroad.com/blog/searching/leetcode-301-remove-invalid-parentheses/">LCDiscussions</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFS {
    private static final char PAREN_OPEN = '(';
    private static final char PAREN_CLOSED = ')';

    public List<String> removeInvalidParentheses(String s) {
        final List<String> ans = new ArrayList<>();
        // sanity check
        if (s == null) {
            return ans;
        }
        // when str.isEmpty(), [""] is expected to be returned, instead of []
        // if(str == null || str.isEmpty()) return ans;

        dfs(0, 0, s, PAREN_OPEN, PAREN_CLOSED, ans);
        return ans;
    }

    private void dfs(final int loStart, final int hiStart, final String str, final char parenOpen, final char parenClosed, final List<String> res) {
        final int L = str.length();
        final char[] chs = str.toCharArray();

        int stack = 0;
        for (int hi = hiStart; hi < L; ++hi) {
            if (chs[hi] == parenOpen) {
                ++stack;
            }
            if (chs[hi] == parenClosed) {
                --stack;
            }
            // after this if block, there will be one surplus closed parenthesis to remove
            if (stack >= 0) {
                continue;
            }

            for (int lo = loStart; lo <= hi; ++lo) {
                if (chs[lo] == parenClosed && (lo == loStart || chs[lo - 1] != parenClosed)) {
                    final String deleted = new StringBuilder(str).deleteCharAt(lo).toString();
                    // or equivalently
                    // String deleted = str.substring(0, lo) + str.substring(lo + 1);
                    dfs(lo, hi, deleted, parenOpen, parenClosed, res);
                }
            }

            return;
        }

        final String reversed = new StringBuilder(str).reverse().toString();
        if (parenOpen == PAREN_OPEN) {
            dfs(0, 0, reversed, PAREN_CLOSED, PAREN_OPEN, res);
        } else {
            res.add(reversed);
        }
    }
}