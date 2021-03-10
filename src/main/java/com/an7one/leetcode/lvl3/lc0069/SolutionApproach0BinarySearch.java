/**
 * https://leetcode.com/problems/sqrtx/
 * 
 * Time Copmlexity:     O(lg(x))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/sqrtx/discuss/25198/3-JAVA-solutions-with-explanation
 */
package com.an7one.leetcode.lvl3.lc0069;

public class SolutionApproach0BinarySearch {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;

        int lo = 1, hi = x;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))
                return mid;
            else if (mid > x / mid)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }
}