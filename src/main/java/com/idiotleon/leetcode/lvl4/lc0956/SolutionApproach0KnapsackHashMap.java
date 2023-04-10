/**
 * https://leetcode.com/problems/tallest-billboard/
 * 
 * Time Complexity:     O(N * sum)
 * Space Complexity:    O(sum)
 * 
 * References:
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-956-tallest-billboard/
 *  https://www.youtube.com/watch?v=iPRWkifQgoo
 *  https://www.youtube.com/watch?v=WqLslW2sFxU
 */
package com.idiotleon.leetcode.lvl4.lc0956;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0KnapsackHashMap {
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        dp.put(0, 0);
        for (int rod : rods) {
            Map<Integer, Integer> cur = new HashMap<Integer, Integer>(dp);
            for (Map.Entry<Integer, Integer> entry : cur.entrySet()) {
                final int KEY = entry.getKey();
                dp.put(KEY + rod, Math.max(dp.containsKey(KEY + rod) ? dp.get(KEY + rod) : 0, cur.get(KEY)));

                dp.put(Math.abs(KEY - rod),
                        Math.max(dp.containsKey(Math.abs(KEY - rod)) ? dp.get(Math.abs(KEY - rod)) : 0,
                                cur.get(KEY) + Math.min(rod, KEY)));
            }
        }

        return dp.get(0);
    }
}