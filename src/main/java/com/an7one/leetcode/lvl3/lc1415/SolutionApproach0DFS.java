/**
 * https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/discuss/587093/Java-Concise-and-clean-solution-imagine-problem-as-a-tree-0ms.
 */
package com.an7one.leetcode.lvl3.lc1415;

public class SolutionApproach0DFS {
    private static final char[] CANDIDATES = { 'a', 'b', 'c' };

    public String getHappyString(int n, int k) {
        StringBuilder builder = new StringBuilder();
        dfs(builder, '-', n, k);
        return builder.toString();
    }

    private void dfs(StringBuilder builder, char last, final int N, final int K) {
        if (N == 0)
            return;

        int step = 1 << (N - 1);
        int to = step;

        for (final char CH : CANDIDATES) {
            if (CH == last)
                continue;

            if (K <= to) {
                dfs(builder.append(CH), CH, N - 1, K - (to - step));
                return;
            }

            to += step;
        }
    }
}
