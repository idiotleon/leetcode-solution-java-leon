/**
 * https://leetcode.com/problems/interval-list-intersections/
 * 
 * Time Complexity:     O(N_A + N_B)
 * Space Complexity:    O(N_A + N_B)
 *  O(N_A + N_B), consumed by the answer list
 * 
 * References:
 *  
 */
package com.idiotleon.leetcode.lvl3.lc0986;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0TwoPointers {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        // sanity check
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return new int[0][0];

        List<int[]> ans = new ArrayList<int[]>();
        final int N_A = A.length, N_B = B.length;

        int idxA = 0, idxB = 0;
        while (idxA < N_A && idxB < N_B) {
            int start = Math.max(A[idxA][0], B[idxB][0]);
            int end = Math.min(A[idxA][1], B[idxB][1]);

            if (start <= end)
                ans.add(new int[] { start, end });

            if (A[idxA][1] < B[idxB][1])
                ++idxA;
            else
                ++idxB;
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}