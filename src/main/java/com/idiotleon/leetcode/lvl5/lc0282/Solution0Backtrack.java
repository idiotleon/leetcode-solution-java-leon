package com.idiotleon.leetcode.lvl5.lc0282;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/expression-add-operators/">LC0282</a>
 * <p>
 * Time Complexity:     O((3 + 1) ^ `L`) ~ O(4 ^ `L`)
 * Space Complexity:    O(`L`)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/expression-add-operators/discuss/71895/Java-Standard-Backtrace-AC-Solutoin-short-and-clear">LCDiscussion</a>
 */
public class Solution0Backtrack {
    private static final char SIGN_PLUS = '+';
    private static final char SIGN_MINUS = '-';
    private static final char SIGN_MULTI = '*';

    public List<String> addOperators(String num, int target) {
        final List<String> ans = new ArrayList<>();
        // sanity check
        if (num == null || num.isEmpty()) {
            return ans;
        }

        backtrack(new StringBuilder(), 0, 0, 0, num, target, ans);
        return ans;
    }

    private void backtrack(final StringBuilder builder, final long prev, final long multi, final int idxStart, final String num, final int target, final List<String> res) {
        final int L = num.length();

        if (idxStart == L) {
            if (target == prev) {
                res.add(builder.toString());
                return;
            }
        }

        for (int idx = idxStart; idx < L; ++idx) {
            if (idx != idxStart && num.charAt(idxStart) == '0') {
                break;
            }

            final long cur = Long.parseLong(num.substring(idxStart, idx + 1));
            final int len = builder.length();
            if (idxStart == 0) {
                backtrack(builder.append(cur), cur, cur, idx + 1, num, target, res);
                builder.setLength(len);
            } else {
                backtrack(builder.append(SIGN_PLUS).append(cur), prev + cur, cur, idx + 1, num, target, res);
                builder.setLength(len);

                backtrack(builder.append(SIGN_MINUS).append(cur), prev - cur, -cur, idx + 1, num, target, res);
                builder.setLength(len);

                backtrack(builder.append(SIGN_MULTI).append(cur), prev - multi + multi * cur, multi * cur, idx + 1, num, target, res);
                builder.setLength(len);
            }
        }
    }
}