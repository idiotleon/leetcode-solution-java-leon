package com.idiotleon.leetcode.lvl3.lc0378;

import java.util.PriorityQueue;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/">LC0378</a>
 * <p>
 * Time Complexity: O(`N` * lg(`k`))
 * Space Complexity: O(`k`)
 */
public class SolutionApproach0MaxHeap {
    public int kthSmallest(int[][] matrix, int k) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        final int NR = matrix.length, NC = matrix[0].length;
        if (k > NR * NC) {
            return -1;
        }

        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));
        for (int[] row : matrix) {
            for (int cur : row) {
                maxHeap.add(cur);

                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.peek();
    }
}