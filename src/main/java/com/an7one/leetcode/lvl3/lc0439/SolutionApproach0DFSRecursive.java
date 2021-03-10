/**
 * https://leetcode.com/problems/ternary-expression-parser/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.an7one.leetcode.lvl3.lc0439;

public class SolutionApproach0DFSRecursive {
    public String parseTernary(String expression) {
        // sanity check
        if (expression == null || expression.isEmpty())
            return "";

        int[] idx = { 0 };
        return Character.toString(dfs(idx, expression));
    }

    private char dfs(int[] idx, String str) {
        final int L = str.length();
        final char CUR = str.charAt(idx[0]);
        if (idx[0] + 1 == L || str.charAt(idx[0] + 1) == ':') {
            idx[0] += 2; // to skip ":"
            return CUR;
        }

        idx[0] += 2; // to skip "?"
        final char LEFT = dfs(idx, str);
        final char RIGHT = dfs(idx, str);
        return CUR == 'T' ? LEFT : RIGHT;
    }
}