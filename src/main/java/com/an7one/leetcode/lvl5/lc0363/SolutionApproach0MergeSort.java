package com.an7one.leetcode.lvl5.lc0363;

import com.an7one.util.Constant;

/**
 * <a href="https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/">LC0363</a>
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/83595/JAVA-117ms-beat-99.81-merge-sort">LC Disucssion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MergeSort {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        final int NR = matrix.length, NC = matrix[0].length;
        int ans = Integer.MIN_VALUE;

        final long[] sum = new long[NR + 1];
        for (int i = 0; i < NC; ++i) {
            final long[] sumInRow = new long[NR];
            for (int j = i; j < NC; ++j) {
                for (int p = 0; p < NR; ++p) {
                    sumInRow[p] += matrix[p][j];
                    sum[p + 1] = sum[p] + sumInRow[p];
                }

                ans = Math.max(ans, mergeSort(sum, 0, NR + 1, k));
                if (ans == k) return k;
            }
        }

        return ans;
    }

    private int mergeSort(final long[] sum, final int start, final int end, final int k) {
        if (end == start + 1) return Integer.MIN_VALUE; // at least 2 required
        int mid = start + (end - start) / 2, count = 0;
        int ans = mergeSort(sum, start, mid, k);
        if (ans == k) return k;
        ans = Math.max(ans, mergeSort(sum, mid, end, k));
        if (ans == k) return k;
        final long[] cache = new long[end - start];
        for (int i = start, j = mid, p = mid; i < mid; ++i) {
            while (j < end && sum[j] - sum[i] <= k) {
                ++j;
            }
            if (j - 1 >= mid) {
                ans = Math.max(ans, (int) (sum[j - 1] - sum[i]));
                if (ans == k) return k;
            }

            while (p < end && sum[p] < sum[i]) {
                cache[count++] = sum[p++];
            }
            cache[count++] = sum[i];
        }

        System.arraycopy(cache, 0, sum, start, count);
        return ans;
    }
}