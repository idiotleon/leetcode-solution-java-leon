/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl5.lc0324;

import java.util.Arrays;

public class SolutionApproach1Sorting {
    public void wiggleSort(int[] nums) {
        final int N = nums.length;
        int mid = (N + 1) >> 1;
        int[] cloned = nums.clone();
        Arrays.sort(cloned); 

        for (int i = mid - 1, j = 0; i >= 0; --i, j += 2)
            nums[j] = cloned[i];

        for (int i = N - 1, j = 1; i >= mid; --i, j += 2)
            nums[j] = cloned[i];
    }
}