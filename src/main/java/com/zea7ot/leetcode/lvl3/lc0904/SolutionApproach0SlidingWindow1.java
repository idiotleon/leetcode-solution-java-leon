/**
 * https://leetcode.com/problems/fruit-into-baskets/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/fruit-into-baskets/discuss/170740/JavaC++Python-Sliding-Window-for-K-Elements/200647
 */
package com.zea7ot.leetcode.lvl3.lc0904;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0SlidingWindow1 {
    public int totalFruit(int[] trees) {
        // sanity check
        if (trees == null || trees.length == 0)
            return 0;

        final int N = trees.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int lo = 0, hi = 0;
        int longest = 0, distinct = 0;

        while (hi < N) {
            int in = trees[hi];
            if (freq.getOrDefault(in, 0) == 0)
                ++distinct;
            freq.put(in, freq.getOrDefault(in, 0) + 1);
            while (distinct > 2) {
                int out = trees[lo];
                if (freq.put(out, freq.get(out) - 1) == 1)
                    --distinct;
                ++lo;
            }

            longest = Math.max(longest, hi - lo + 1);
            ++hi;
        }

        return longest;
    }
}