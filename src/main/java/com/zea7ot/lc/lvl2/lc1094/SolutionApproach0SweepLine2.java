/**
 * https://leetcode.com/problems/car-pooling/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/car-pooling/discuss/317887/JavaPython-3-Clean-codes-w-explanation-and-brief-analysis.
 */
package com.zea7ot.lc.lvl2.lc1094;

import java.util.PriorityQueue;

public class SolutionApproach0SweepLine2 {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(
                (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        for (int[] trip : trips) {
            minHeap.offer(new int[] { trip[2], -trip[0] });
            minHeap.offer(new int[] { trip[1], trip[0] });
        }

        while (!minHeap.isEmpty()) {
            capacity -= minHeap.poll()[1];
            if (capacity < 0)
                return false;
        }

        return true;
    }
}