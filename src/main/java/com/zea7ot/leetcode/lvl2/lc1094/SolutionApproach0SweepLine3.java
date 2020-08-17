/**
 * https://leetcode.com/problems/car-pooling/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/car-pooling/discuss/317887/JavaPython-3-Clean-codes-w-explanation-and-brief-analysis.
 */
package com.zea7ot.leetcode.lvl2.lc1094;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproach0SweepLine3 {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[2], b[2]));
        for (int[] trip : trips) {
            while (!minHeap.isEmpty() && trip[1] >= minHeap.peek()[2]) {
                capacity += minHeap.poll()[0];
            }

            capacity -= trip[0];
            if (capacity < 0)
                return false;
            minHeap.offer(trip);
        }

        return true;
    }
}