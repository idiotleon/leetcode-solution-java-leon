/**
 * https://leetcode.com/problems/image-overlap/
 * 
 * Time Complexity:     O(NR * NC) ~ O(N * N) ~ O(N ^ 2)
 * Space Complexity:    O(NR * NC) ~ O(N * N) ~ O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/image-overlap/discuss/130623/C%2B%2BJavaPython-Straight-Forward
 */
package com.an7one.leetcode.lvl3.lc0835;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0LinearScan1 {
    public int largestOverlap(int[][] A, int[][] B) {
        final int N = A.length;
        List<Integer> serialA = new ArrayList<>();
        List<Integer> serialB = new ArrayList<>();

        for (int i = 0; i < N * N; ++i) {
            if (A[i / N][i % N] == 1)
                serialA.add(i / N * 100 + i % N);

            if (B[i / N][i % N] == 1)
                serialB.add(i / N * 100 + i % N);
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int a : serialA)
            for (int b : serialB)
                freq.put(a - b, freq.getOrDefault(a - b, 0) + 1);

        int largest = 0;
        for (int val : freq.values())
            largest = Math.max(largest, val);
        return largest;
    }
}
