package com.an7one.leetcode.lvl2.lc0784;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/letter-case-permutation/">LC0784</a>
 * <p>
 * Time Complexity:     O(2 ^ letters(L)) ~ O(2 ^ L)
 * L, length of the input String S
 * letters(L), the length of letters, not digits, in String S
 * <p>
 * Space Complexity:    O(L) + O(L) ~ O(L)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/letter-case-permutation/discuss/656296/Java-Clean-Code-DFS-%2B-BFS">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive {
    public List<String> letterCasePermutation(String S) {
        final List<String> ans = new ArrayList<>();
        // sanity check
        if (S == null || S.isEmpty()) return ans;

        dfs(0, S.toCharArray(), ans);
        return ans;
    }

    private void dfs(final int idx, final char[] chs, final List<String> res) {
        if (idx >= chs.length) {
            res.add(String.valueOf(chs));
            return;
        }

        if (chs[idx] >= '0' && chs[idx] <= '9') {
            dfs(idx + 1, chs, res);
            return;
        }

        chs[idx] = Character.toLowerCase(chs[idx]);
        dfs(idx + 1, chs, res);

        chs[idx] = Character.toUpperCase(chs[idx]);
        dfs(idx + 1, chs, res);
    }
}