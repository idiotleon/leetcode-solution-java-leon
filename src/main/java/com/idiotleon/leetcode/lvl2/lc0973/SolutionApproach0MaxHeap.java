
package com.idiotleon.leetcode.lvl2.lc0973;

import com.idiotleon.util.Constant;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * <p>
 * Time Complexity:     O(N * lg(`K`))
 * Space Complexity:    O(`K`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MaxHeap {
    public int[][] kClosest(int[][] points, int K) {
        // sanity check
        if (points == null || points.length < K)
            return points;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(
                (a, b) -> Long.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K)
                maxHeap.poll();
        }

        int[][] ans = new int[K][2];
        for (int i = K - 1; i >= 0; --i)
            ans[i] = maxHeap.poll();

        return ans;
    }
}