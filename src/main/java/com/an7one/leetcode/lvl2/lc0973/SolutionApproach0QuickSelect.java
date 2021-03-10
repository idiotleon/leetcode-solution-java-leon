/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * 
 * Time Complexity:     O(N) averagely, O(N ^ 2) in the worst case
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc0973;

import java.util.Arrays;

public class SolutionApproach0QuickSelect {
    public int[][] kClosest(int[][] points, int K) {
        // sanit check
        if (points == null || points.length == 0 || points[0].length == 0)
            return new int[0][0];

        final int N = points.length;
        int lo = 0, hi = N - 1;
        while (lo < hi) {
            int mid = partition(lo, hi, points);
            if (mid == K)
                break;
            if (mid < K)
                lo = mid + 1;
            else
                hi = mid;
        }

        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int lo, int hi, int[][] nums) {
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

    private int compare(int[] a, int[] b) {
        return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
    }
}