/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
package main.java.lcidiot.lc0973;

import java.util.PriorityQueue;

class SolutionApproachHeap {
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