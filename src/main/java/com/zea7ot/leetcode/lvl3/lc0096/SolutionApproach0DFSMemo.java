/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * 
 * Time Complexity:     O(`n` ^ 2)
 * Space Complexity:    O(`n`)
 * 
 * References:
 *  https://leetcode.com/problems/unique-binary-search-trees/discuss/31696/Simple-Recursion-Java-Solution-with-Explanation/30507
 *  https://leetcode.com/problems/unique-binary-search-trees/discuss/31696/Simple-Recursion-Java-Solution-with-Explanation
 */
package com.zea7ot.leetcode.lvl3.lc0096;

public class SolutionApproach0DFSMemo {
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if (memo[n] != 0)
            return memo[n];

        if (n <= 1)
            return 1;

        int total = 0;
        for (int i = 1; i <= n; ++i)
            total += dfs(i - 1, memo) * dfs(n - i, memo);

        return memo[n] = total;
    }
}