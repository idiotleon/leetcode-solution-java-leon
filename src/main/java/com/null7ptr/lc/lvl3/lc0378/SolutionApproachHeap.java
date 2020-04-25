/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * Example:
 * 
 * matrix = [ [ 1, 5, 9], [10, 11, 13], [12, 13, 15]]
 * 
 * k = 8,
 * 
 * return 13. Note: You may assume k is always valid, 1 ≤ k ≤ n2.
 */

package com.null7ptr.lc.lvl3.lc0378;

import java.util.PriorityQueue;

public class SolutionApproachHeap {
    public int kthSmallest(int[][] matrix, int k) {
        // invalid input: k is too small
        if (k < 1)
            return -1;
        // edge case 1: the matrix is empty
        int m = matrix.length;
        if (m == 0)
            return -1;
        int n = matrix[0].length;
        // invalid input: k is too large
        if (m * n < k)
            return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int j = 0; j < m; j++){
            for (int i = 0; i < n; i++){
                pq.add(matrix[i][j]);
            }
        }

        while (k > 1) {
            pq.poll();
            k--;
        }

        return pq.poll();
    }
}