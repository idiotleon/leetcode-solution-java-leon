/**
 * https://leetcode.com/problems/expression-add-operators/
 * 
 * Time Complexity:     O((3 + 1) ^ L) ~ O(4 ^ L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/expression-add-operators/discuss/71895/Java-Standard-Backtrace-AC-Solutoin-short-and-clear
 */
package com.idiotleon.leetcode.lvl5.lc0282;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if (num == null || num.isEmpty())
            return ans;

        dfs("", 0, 0, 0, num, target, ans);

        return ans;
    }

    private void dfs(String path, long res, long prev, int idx, String num, int target, List<String> paths) {
        final int L = num.length();
        if (idx == num.length()) {
            if (target == res) {
                paths.add(path);
                return;
            }
        }

        for (int i = idx; i < L; i++) {
            if (i != idx && num.charAt(idx) == '0')
                break;
            long cur = Long.parseLong(num.substring(idx, i + 1));
            if (idx == 0) {
                dfs(path + cur, cur, cur, i + 1, num, target, paths);
            } else {
                dfs(path + '+' + cur, res + cur, cur, i + 1, num, target, paths);

                dfs(path + "-" + cur, res - cur, -cur, i + 1, num, target, paths);

                dfs(path + "*" + cur, res - prev + prev * cur, prev * cur, i + 1, num, target, paths);
            }
        }
    }
}