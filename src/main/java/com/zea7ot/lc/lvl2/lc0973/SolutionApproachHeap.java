/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(K)
 */
package com.zea7ot.lc.lvl2.lc0973;

import java.util.PriorityQueue;

public class SolutionApproachHeap {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
        
        for(int[] point : points){
            heap.offer(point);
            if(heap.size() > K){
                heap.poll();
            }
        }
        
        int[][] res = new int[K][2];
        while(K > 0){
            res[--K] = heap.poll();
        }
        
        return res;
    }
}