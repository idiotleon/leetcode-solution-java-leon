/**
 * https://leetcode.com/problems/expression-add-operators/
 * 
 * Time Complexity:     O((3 + 1) ^ L) ~ O(4 ^ L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/expression-add-operators/discuss/71895/Java-Standard-Backtrace-AC-Solutoin-short-and-clear
 */
package com.an7one.leetcode.lvl5.lc0282;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    private static final char SIGN_PLUS = '+';
    private static final char SIGN_MINUS = '-';
    private static final char SIGN_MULTI = '*';

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        // sanity check
        if (num == null || num.isEmpty())
            return ans;

        backtrack(new StringBuilder(), 0, 0, 0, num, target, ans);
        return ans;
    }

    private void backtrack(StringBuilder builder, long prev, long multi, int idx, String num, int target,
            List<String> res) {
        final int L = num.length();

        if (idx == L) {
            if (target == prev) {
                res.add(builder.toString());
                return;
            }
        }

        for (int i = idx; i < L; ++i) {
            if (i != idx && num.charAt(idx) == '0')
                break;

            long cur = Long.parseLong(num.substring(idx, i + 1));
            final int LEN = builder.length();
            if (idx == 0) {
                backtrack(builder.append(cur), cur, cur, i + 1, num, target, res);
                builder.setLength(LEN);
            } else {
                backtrack(builder.append(SIGN_PLUS).append(cur), prev + cur, cur, i + 1, num, target, res);
                builder.setLength(LEN);

                backtrack(builder.append(SIGN_MINUS).append(cur), prev - cur, -cur, i + 1, num, target, res);
                builder.setLength(LEN);

                backtrack(builder.append(SIGN_MULTI).append(cur), prev - multi + multi * cur, multi * cur, i + 1, num,
                        target, res);
                builder.setLength(LEN);
            }
        }
    }
}