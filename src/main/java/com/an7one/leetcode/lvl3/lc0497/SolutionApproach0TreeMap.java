/**
 * https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.an7one.leetcode.lvl3.lc0497;

import java.util.Random;
import java.util.TreeMap;

public class SolutionApproach0TreeMap {
    private TreeMap<Integer, Integer> map;
    private final int[][] RECTS;
    private int sum;
    private Random rand;

    public SolutionApproach0TreeMap(int[][] rects) {
        this.RECTS = rects;
        this.map = new TreeMap<>();
        this.sum = 0;
        this.rand = new Random();

        final int NR = RECTS.length;
        for (int row = 0; row < NR; ++row) {
            int[] rect = RECTS[row];

            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);

            map.put(sum, row);
        }
    }

    public int[] pick() {
        int key = map.ceilingKey(rand.nextInt(sum) + 1);

        return pickInRect(RECTS[map.get(key)]);
    }

    private int[] pickInRect(int[] rect) {
        int left = rect[0], right = rect[2], bottom = rect[1], top = rect[3];

        return new int[] { left + rand.nextInt(right - left + 1), bottom + rand.nextInt(top - bottom + 1) };
    }
}