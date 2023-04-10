/**
 * https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(lg(N))
 * 
 * References:
 *  https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/discuss/794162/C%2B%2BJavaPython-5-lines
 */
package com.idiotleon.leetcode.lvl4.lc1553;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFSMemo {
    public int minDays(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(n, memo);
    }

    private int dfs(int n, Map<Integer, Integer> memo) {
        if (n <= 1)
            return n;
        if (!memo.containsKey(n))
            memo.put(n, 1 + Math.min(n % 2 + dfs(n / 2, memo), n % 3 + dfs(n / 3, memo)));
        return memo.get(n);
    }
}