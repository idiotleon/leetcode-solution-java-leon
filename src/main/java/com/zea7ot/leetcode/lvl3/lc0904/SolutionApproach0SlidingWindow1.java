/**
 * https://leetcode.com/problems/fruit-into-baskets/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * to find out the subarrays of the longest length with at most 2 distinct numbers
 * 
 * References:
 *  https://leetcode.com/problems/fruit-into-baskets/discuss/170740/JavaC%2B%2BPython-Sliding-Window-for-K-Elements
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
        int longest = 0;

        while (hi < N) {
            freq.put(trees[hi], freq.getOrDefault(trees[hi], 0) + 1);
            while (freq.size() > 2) {
                freq.put(trees[lo], freq.get(trees[lo]) - 1);
                freq.remove(trees[lo], 0);
                ++lo;
            }

            longest = Math.max(longest, hi - lo + 1);
            ++hi;
        }

        return longest;
    }
}