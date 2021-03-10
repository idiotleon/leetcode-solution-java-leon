/**
 * https://leetcode.com/problems/car-pooling/
 * 
 * Time Complexity:     O(RANGE) ~ O(1001)
 * Space Complexity:    O(1001) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/car-pooling/discuss/317611/C%2B%2BJava-O(n)-Thousand-and-One-Stops
 */
package com.an7one.leetcode.lvl2.lc1094;

public class SolutionApproach0SweepLine {
    public boolean carPooling(int[][] trips, int capacity) {
        final int RANGE = 1001;
        int[] stops = new int[RANGE];
        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];
            stops[start] += passengers;
            stops[end] -= passengers;
        }

        for (int stop : stops) {
            capacity -= stop;
            if (capacity < 0)
                return false;
        }

        return true;

        // almost equivalently
        // for(int i = 0; i < RANGE && capacity >= 0; i++)
        // capacity -= stops[i];

        // return capacity >= 0;
    }
}