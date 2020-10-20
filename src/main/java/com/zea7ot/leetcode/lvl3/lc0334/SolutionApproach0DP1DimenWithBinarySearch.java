/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 * 
 * Time Complexity:     O(`N` * lg(`N`))
 * Space Complexity:    O(`N`)
 */
package com.zea7ot.leetcode.lvl3.lc0334;

public class SolutionApproach0DP1DimenWithBinarySearch {
    public boolean increasingTriplet(int[] nums) {
        final int N = nums.length;
        int[] tails = new int[N];
        int size = 0;
        for (int num : nums) {
            int lo = 0, hi = size;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (tails[mid] < num) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            tails[lo] = num;
            if (lo == size) {
                ++size;
                if (size >= 3)
                    return true;
            }
        }

        return false;
    }
}