/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(K)
 */
package com.zea7ot.lc.lvl2.lc0973;

import java.util.PriorityQueue;

public class SolutionApproach0MaxHeap {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(
                (a, b) -> Long.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[K][2];
        int idx = K - 1;
        while(idx >= 0)
            ans[idx--] = maxHeap.poll();
        
        return ans;
    }
}