/**
 * https://leetcode.com/problems/car-pooling/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/car-pooling/discuss/317611/C%2B%2BJava-O(n)-Thousand-and-One-Stops
 */
package com.zea7ot.leetcode.lvl2.lc1094;

import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach0SweepLine1 {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];
            map.put(start, map.getOrDefault(start, 0) + passengers);
            map.put(end, map.getOrDefault(end, 0) - passengers);
        }

        for (int value : map.values()) {
            capacity -= value;
            if (capacity < 0)
                return false;
        }

        return true;
    }
}