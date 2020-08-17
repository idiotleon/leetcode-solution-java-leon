/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * 
 * Time Complexity:     O(N) averagely ~ O(N ^ 2) in the worst case
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0973;

import java.util.Arrays;

public class SolutionApproach0QuickSelect {
    public int[][] kClosest(int[][] points, int K) {
        final int N = points.length;
        int lo = 0, hi = N - 1;
        while (lo < hi) {
            int mid = partition(points, lo, hi);
            if (mid == K)
                break;
            if (mid < K) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] nums, int lo, int hi) {
        int[] pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && compare(nums[hi], pivot) >= 0)
                --hi;
            nums[lo] = nums[hi];
            while (lo < hi && compare(nums[lo], pivot) <= 0)
                ++lo;
            nums[hi] = nums[lo];
        }

        nums[lo] = pivot;
        return lo;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}