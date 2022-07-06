package com.an7one.leetcode.lvl1.lc0509;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/fibonacci-number/">LC0509</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/fibonacci-number/discuss/215992/Java-Solutions">Leetcode Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSMemo {
    public int fib(int N) {
        int[] memo = new int[31];
        return dfs(N, memo);
    }

    private int dfs(int num, int[] memo) {
        if (num <= 1)
            return num;

        if (memo[num] != 0)
            return memo[num];

        return dfs(num - 1, memo) + dfs(num - 2, memo);
    }
}