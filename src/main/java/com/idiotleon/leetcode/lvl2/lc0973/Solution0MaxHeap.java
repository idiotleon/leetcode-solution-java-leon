package com.idiotleon.leetcode.lvl2.lc0973;

import com.idiotleon.util.Constant;

import java.util.PriorityQueue;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/k-closest-points-to-origin/">lc0973</a>
 * <p>
 * Time Complexity:     O(N * lg(`K`))
 * Space Complexity:    O(`K`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution0MaxHeap {
    public int[][] kClosest(final int[][] points, final int K) {
        if (points == null || points.length < K) {
            return points;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Long.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        final int[][] ans = new int[K][2];
        for (int i = K - 1; i >= 0; --i) {
            ans[i] = maxHeap.poll();
        }

        return ans;
    }
}