/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * Time Complexity: O(N * lg(k))
 * Space Complexity: O(k)
 */
package com.polyg7ot.lc.lvl3.lc0378;

import java.util.PriorityQueue;

public class SolutionApproach0MaxHeap {
    public int kthSmallest(int[][] matrix, int k) {
        // sanity check
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;

        final int NR = matrix.length, NC = matrix[0].length;
        if(k > NR * NC) return -1;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((e1, e2) -> Integer.compare(e2, e1));
        for (int row = 0; row < NR; row++){
            for (int col = 0; col < NC; col++){
                maxHeap.add(matrix[row][col]);
                
                if(maxHeap.size() > k) maxHeap.poll();
            }
        }

        return maxHeap.poll();
    }
}