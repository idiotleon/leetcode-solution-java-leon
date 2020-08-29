/**
 * https://leetcode.com/problems/fibonacci-number/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/fibonacci-number/discuss/215992/Java-Solutions
 */
package com.zea7ot.leetcode.lvl1.lc0509;

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