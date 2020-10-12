/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 * 
 * Steps:
 *  1. to sort by end point
 *  2. to merge if cur[0] (start of cur) < last, otherwise, a new arrow is required (then to reset "last")
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/geometry/leetcode-452-minimum-number-of-arrows-to-burst-balloons/
 */
package com.zea7ot.leetcode.lvl3.lc0452;

import java.util.Arrays;

public class SolutionApproach0Greedy {
    public int findMinArrowShots(int[][] points) {
        // sanity check
        if (points == null || points.length == 0)
            return 0;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int prevEnd = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if (point[0] > prevEnd) {
                prevEnd = point[1];
                ++ans;
            }
        }

        return ans;
    }
}