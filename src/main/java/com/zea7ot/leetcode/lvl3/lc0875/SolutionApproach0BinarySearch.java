/**
 * https://leetcode.com/problems/koko-eating-bananas/
 * 
 * Time Complexity:     O(N * lg(RANGE))
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0875;

public class SolutionApproach0BinarySearch {
    public int minEatingSpeed(int[] piles, int H) {
        final int RANGE = (int) 1e9 + 1;

        int lo = 1, hi = RANGE;
        while (lo < hi) {
            int totalHours = 0;

            int mid = lo + (hi - lo) / 2;
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
            }

            if (totalHours > H)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }
}