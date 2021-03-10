/**
 * https://leetcode.com/problems/max-value-of-equation/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 *
 * a sliding window approach with a monotonic deque
 *
 * References:
 *  https://leetcode.com/problems/max-value-of-equation/discuss/709231/JavaPython-Priority-Queue-and-Deque-Solution-O(N)
 */
package com.an7one.leetcode.lvl4.lc1499;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0SlidingWindow {
    public int findMaxValueOfEquation(int[][] points, int k) {
        // not used
        // final int N = points.length;

        int max = Integer.MIN_VALUE;
        Deque<Node> deque = new ArrayDeque<>();

        for (int[] point : points) {
            while (!deque.isEmpty() && point[0] - deque.peekFirst().xCoor > k) {
                deque.removeFirst();
            }

            if (!deque.isEmpty()) {
                max = Math.max(max, deque.peekFirst().variance + point[0] + point[1]);
            }

            while (!deque.isEmpty() && point[1] - point[0] > deque.peekLast().variance) {
                deque.removeLast();
            }

            deque.addLast(new Node(point[1] - point[0], point[0]));
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
