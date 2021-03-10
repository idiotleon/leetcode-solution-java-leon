/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * if the bottom being 0 means leaks.
 * only the concave of the bottom large than 0 can hold the water.
 * 
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl4.lc0042.followup;

public class SolutionApproach1TwoPointers {
    public int trap(int[] heights) {
        // sanity check
        if (heights == null || heights.length == 0)
            return 0;

        final int N = heights.length;
        int water = 0;
        int left = 0, right = 0;

        while (right < N) {
            while (right < N && heights[right] == 0)
                right++;
            left = right - 1;
            while (right < N && heights[right] != 0)
                right++;
            water += trap(heights, left, right);
        }

        return water;
    }

    private int trap(int[] heights, int lo, int hi) {
        int left = lo, right = hi - 1;
        int leftMax = heights[left], rightMax = heights[right];
        int water = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                water += leftMax - heights[left];
                leftMax = Math.max(leftMax, heights[++left]);
            } else {
                water += rightMax - heights[right];
                rightMax = Math.max(rightMax, heights[--right]);
            }
        }

        return water;
    }
}