package com.idiotleon.leetcode.ood.lvl2.lc1570;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0TwoPointers {

    final List<int[]> LIST;

    SolutionApproach0TwoPointers(int[] nums) {
        this.LIST = new ArrayList<>();

        final int N = nums.length;
        for (int i = 0; i < N; ++i) {
            if (nums[i] != 0) {
                LIST.add(new int[] { i, nums[i] });
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SolutionApproach0TwoPointers vec) {
        int ans = 0;

        final int SIZE = LIST.size();
        final List<int[]> LIST_V = vec.LIST;
        final int SIZE_VEC = LIST_V.size();

        int i = 0, j = 0;

        while (i < SIZE && j < SIZE_VEC) {
            int[] eleThis = LIST.get(i);
            int[] eleThat = LIST_V.get(j);

            if (eleThis[0] < eleThat[0]) {
                ++i;
            } else if (eleThis[0] > eleThat[0]) {
                ++j;
            } else {
                ans += eleThis[1] * eleThat[1];
                ++i;
                ++j;
            }
        }

        return ans;
    }
}
