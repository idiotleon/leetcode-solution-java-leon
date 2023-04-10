package com.idiotleon.leetcode.lvl1.lc0509;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/fibonacci-number/">LC0509</a>
 * <p>
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/fibonacci-number/discuss/215992/Java-Solutions">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DFSNaive {
    public int fib(int N) {
        return dfs(N);
    }

    private int dfs(int N) {
        if (N <= 1)
            return N;

        return dfs(N - 1) + dfs(N - 2);
    }
}