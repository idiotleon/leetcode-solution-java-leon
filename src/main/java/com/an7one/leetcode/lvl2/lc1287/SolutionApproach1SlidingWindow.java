/**
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc1287;

public class SolutionApproach1SlidingWindow {
    public int findSpecialInteger(int[] arr) {
        final int N = arr.length, T = N / 4;
        for (int i = 0; i < N - T; ++i) {
            if (arr[i] == arr[i + T])
                return arr[i];
        }

        return -1;
    }
}