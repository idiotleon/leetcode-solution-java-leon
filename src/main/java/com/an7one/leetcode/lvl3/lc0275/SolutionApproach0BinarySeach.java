/**
 * https://leetcode.com/problems/h-index-ii/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl3.lc0275;

public class SolutionApproach0BinarySeach {
    public int hIndex(int[] citations) {
        // sanity check
        if (citations == null || citations.length == 0)
            return 0;

        final int N = citations.length;
        int lo = 0, hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] == N - mid)
                return N - mid;
            if (citations[mid] < N - mid)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return N - lo;
    }
}