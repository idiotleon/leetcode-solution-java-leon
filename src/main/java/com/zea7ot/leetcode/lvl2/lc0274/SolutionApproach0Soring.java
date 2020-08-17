/**
 * https://leetcode.com/problems/h-index/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0274;

import java.util.Arrays;

public class SolutionApproach0Soring {
    public int hIndex(int[] citations) {
        // sanity check
        if (citations == null || citations.length == 0)
            return 0;

        final int N = citations.length;
        Arrays.sort(citations);
        int idx = 0;
        while (idx < N && citations[N - 1 - idx] > idx)
            ++idx;

        return idx;
    }
}