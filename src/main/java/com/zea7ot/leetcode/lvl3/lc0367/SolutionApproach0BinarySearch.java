/**
 * https://leetcode.com/problems/valid-perfect-square/
 * 
 * Time Complexity:     O(lg(num))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/valid-perfect-square/discuss/160184/Java-Binary-Search-Beats-100
 */
package com.zea7ot.leetcode.lvl3.lc0367;

public class SolutionApproach0BinarySearch {
    public boolean isPerfectSquare(int num) {
        if (num < 2)
            return true;

        int lo = 0, hi = num / 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // num % mid == 0
            // to make sure no fraction
            if (mid == num / mid && num % mid == 0)
                return true;
            if (mid > num / mid)
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return false;
    }
}