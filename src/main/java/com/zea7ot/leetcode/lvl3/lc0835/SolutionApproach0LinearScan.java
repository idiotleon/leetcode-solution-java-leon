/**
 * https://leetcode.com/problems/image-overlap/
 * 
 * Time Complexity:     O(NR * NC) ~ O(N * N) ~ O(N ^ 2)
 * Space Complexity:    O(NR * NC) ~ O(N * N) ~ O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/image-overlap/discuss/130623/C++JavaPython-Straight-Forward/183969
 */
package com.zea7ot.leetcode.lvl3.lc0835;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0LinearScan {
    public int largestOverlap(int[][] A, int[][] B) {
        final int N = A.length;
        List<int[]> serialA = new ArrayList<>();
        List<int[]> serialB = new ArrayList<>();

        for (int row = 0; row < N; ++row)
            for (int col = 0; col < N; ++col) {
                if (A[row][col] == 1)
                    serialA.add(new int[] { row, col });

                if (B[row][col] == 1)
                    serialB.add(new int[] { row, col });
            }

        int largest = 0;
        Map<String, Integer> freq = new HashMap<>();
        for (int[] a : serialA)
            for (int[] b : serialB) {
                String hash = (a[0] - b[0]) + "," + (a[1] - b[1]);
                freq.put(hash, freq.getOrDefault(hash, 0) + 1);
                largest = Math.max(largest, freq.get(hash));
            }

        return largest;
    }
}
