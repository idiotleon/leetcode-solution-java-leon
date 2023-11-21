package com.idiotleon.leetcode.lvl5.lc0282;

import com.idiotleon.util.Constant;

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
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Backtrack1 {
    public List<String> addOperators(String num, int target) {
        final List<String> ans = new ArrayList<>();
        // sanity check
        if (num == null || num.isEmpty()) {
            return ans;
        }

        dfs("", 0, 0, 0, num, target, ans);

        return ans;
    }

    private void dfs(final String path, final long res, final long prev, final int idxStart, final String num, final int target, final List<String> paths) {
        final int L = num.length();
        if (idxStart == L) {
            if (target == res) {
                paths.add(path);
                return;
            }
        }

        for (int idx = idxStart; idx < L; ++idx) {
            if (idx != idxStart && num.charAt(idxStart) == '0') {
                break;
            }
            final long cur = Long.parseLong(num.substring(idxStart, idx + 1));
            if (idxStart == 0) {
                dfs(path + cur, cur, cur, idx + 1, num, target, paths);
            } else {
                dfs(path + '+' + cur, res + cur, cur, idx + 1, num, target, paths);

                dfs(path + "-" + cur, res - cur, -cur, idx + 1, num, target, paths);

                dfs(path + "*" + cur, res - prev + prev * cur, prev * cur, idx + 1, num, target, paths);
            }
        }
    }
}