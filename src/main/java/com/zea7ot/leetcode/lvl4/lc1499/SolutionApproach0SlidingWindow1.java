/**
 * https://leetcode.com/problems/max-value-of-equation/
 * 
 * Time Complexity:     O(`N` * lg(`N`))
 * Space Complexity:    O(`N`)
 * 
 * a sliding window approach with a max heap/PQ
 * 
 * References:
 *  https://leetcode.com/problems/max-value-of-equation/discuss/709231/JavaPython-Priority-Queue-and-Deque-Solution-O(N)
 */
package com.zea7ot.leetcode.lvl4.lc1499;

import java.util.PriorityQueue;

public class SolutionApproach0SlidingWindow1 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        // not used
        // final int N = points.length;

        int max = Integer.MIN_VALUE;
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(
                (a, b) -> a.variance == b.variance ? Integer.compare(a.xCoor, b.xCoor)
                        : Integer.compare(b.variance, a.variance));

        for (int[] point : points) {
            while (!maxHeap.isEmpty() && point[0] - maxHeap.peek().xCoor > k) {
                maxHeap.poll();
            }

            if (!maxHeap.isEmpty()) {
                max = Math.max(max, maxHeap.peek().variance + point[0] + point[1]);
            }

            maxHeap.offer(new Node(point[1] - point[0], point[0]));
        }

        return max;
    }

    private class Node {
        private int variance;
        private int xCoor;

        private Node(int variance, int xCoor) {
            this.variance = variance;
            this.xCoor = xCoor;
        }
    }
}
