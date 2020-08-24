/**
 * https://leetcode.com/problems/fruit-into-baskets/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(2) ~ O(1)
 * 
 * to find out the subarrays of the longest length with at most 2 distinct numbers
 * 
 * References:
 *  https://leetcode.com/problems/fruit-into-baskets/discuss/170740/JavaC%2B%2BPython-Sliding-Window-for-K-Elements
 */
package com.zea7ot.leetcode.lvl3.lc0904;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0SlidingWindow {
    public int totalFruit(int[] trees) {
        // sanity check
        if (trees == null || trees.length == 0)
            return 0;

        final int N = trees.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int lo = 0, hi = 0;
        int longest = 0;

        while (hi < N) {
            int in = trees[hi];
            freq.put(in, freq.getOrDefault(in, 0) + 1);

            while (freq.size() > 2) {
                int out = trees[lo];
                freq.put(out, freq.get(out) - 1);
                freq.remove(out, 0);
                ++lo;
            }

            longest = Math.max(longest, hi - lo + 1);
            ++hi;
        }

        return longest;
    }
}