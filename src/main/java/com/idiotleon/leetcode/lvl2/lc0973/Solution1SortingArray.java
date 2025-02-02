package com.idiotleon.leetcode.lvl2.lc0973;

import com.idiotleon.util.Constant;

import java.util.Arrays;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/k-closest-points-to-origin/">lc0972</a>
 * <p>
 * Time Complexity:     O(N * lgN)
 * Space Complexity:    O(1)
 */
@SuppressWarnings({Constant.WARNING.UNUSED})
public class Solution1SortingArray {
    public int[][] kClosest(final int[][] points, final int K) {
        Arrays.sort(points, (p1, p2) -> (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
}