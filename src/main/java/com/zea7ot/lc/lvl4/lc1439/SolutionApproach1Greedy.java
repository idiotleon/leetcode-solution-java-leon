/**
 * https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
 * 
 * Time Complexity:     O(NR * NC * k * lg(k))
 * Space Complexity:    O(k)
 * 
 * References:
 *  https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/discuss/609812/Java-Max-Priority-Queue-O(m-*-n-*-k-*-log(k))
 */
package com.zea7ot.lc.lvl4.lc1439;

import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach1Greedy {
    public int kthSmallest(int[][] mat, int k) {
        final int COLS = Math.min(mat[0].length, k);
        
        Queue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        maxHeap.offer(0);
        for(int[] row : mat){
            Queue<Integer> nextMaxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
            for(int num : maxHeap){
                for(int col = 0; col < COLS; col++){
                    nextMaxHeap.offer(num + row[col]);
                    if(nextMaxHeap.size() > k){
                        nextMaxHeap.poll();
                    }
                }
            }
            maxHeap = nextMaxHeap;
        }
        
        return maxHeap.poll();
    }
}