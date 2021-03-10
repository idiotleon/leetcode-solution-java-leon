/**
 * https://leetcode.com/problems/car-pooling/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 */
package com.an7one.leetcode.lvl2.lc1094;

import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach0SweepLine4 {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> timeline = new TreeMap<Integer, Integer>();
        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];
            timeline.put(start, timeline.getOrDefault(start, 0) + passengers);
            timeline.put(end, timeline.getOrDefault(end, 0) - passengers);
        }

        int count = 0, required = 0;
        for (int val : timeline.values()) {
            count += val;
            required = Math.max(required, count);
        }

        return required <= capacity;
    }
}