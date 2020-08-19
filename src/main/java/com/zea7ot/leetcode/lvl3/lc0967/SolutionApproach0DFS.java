/**
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 * 
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity:    O(2 ^ N)
 * 
 * References:
 *  https://leetcode.com/problems/numbers-with-same-consecutive-differences/discuss/211433/JavaPython-3-BFSDFS-codes-w-brief-explanation-and-analysis.
 */
package com.zea7ot.leetcode.lvl3.lc0967;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS {
    public int[] numsSameConsecDiff(int N, int K) {
        // sanity check
        if (N <= 0)
            return new int[0];
        if (N == 1)
            return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < 10; ++i)
            dfs(N, K, i, ans);

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(final int N, final int K, int num, List<Integer> res) {
        if (N == 1) {
            res.add(num);
        } else if (num > 0) {
            int digit1 = num % 10 - K;
            int digit2 = num % 10 + K;

            if (digit1 >= 0)
                dfs(N - 1, K, num * 10 + digit1, res);

            if (digit2 != digit1 && digit2 < 10)
                dfs(N - 1, K, num * 10 + digit2, res);
        }
    }
}