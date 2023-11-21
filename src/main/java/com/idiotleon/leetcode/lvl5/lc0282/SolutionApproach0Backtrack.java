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
public class SolutionApproach0Backtrack {
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

    private void backtrack(final StringBuilder builder, final long prev, final long multi, final int idx, final String num, final int target, final List<String> res) {
        final int L = num.length();

        if (idx == L) {
            if (target == prev) {
                res.add(builder.toString());
                return;
            }
        }

        for (int i = idx; i < L; ++i) {
            if (i != idx && num.charAt(idx) == '0') {
                break;
            }

            final long cur = Long.parseLong(num.substring(idx, i + 1));
            final int LEN = builder.length();
            if (idx == 0) {
                backtrack(builder.append(cur), cur, cur, i + 1, num, target, res);
                builder.setLength(LEN);
            } else {
                backtrack(builder.append(SIGN_PLUS).append(cur), prev + cur, cur, i + 1, num, target, res);
                builder.setLength(LEN);

                backtrack(builder.append(SIGN_MINUS).append(cur), prev - cur, -cur, i + 1, num, target, res);
                builder.setLength(LEN);

                backtrack(builder.append(SIGN_MULTI).append(cur), prev - multi + multi * cur, multi * cur, i + 1, num, target, res);
                builder.setLength(LEN);
            }
        }
    }
}