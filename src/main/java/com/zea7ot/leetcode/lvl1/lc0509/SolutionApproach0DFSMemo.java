/**
 * https://leetcode.com/problems/fibonacci-number/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/fibonacci-number/discuss/215992/Java-Solutions
 */
package com.zea7ot.leetcode.lvl1.lc0509;

public class SolutionApproach0DFSMemo {
    public int fib(int N) {
        int[] memo = new int[31];
        return dfs(N, memo);
    }

    private int dfs(int N, int[] memo) {
        if (N <= 1)
            return N;

        if (memo[N] != 0)
            return memo[N];

        return dfs(N - 1, memo) + dfs(N - 2, memo);
    }
}