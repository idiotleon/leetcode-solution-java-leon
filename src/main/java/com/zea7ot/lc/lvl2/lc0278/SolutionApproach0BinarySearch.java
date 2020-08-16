/**
 * https://leetcode.com/problems/first-bad-version/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl2.lc0278;

public class SolutionApproach0BinarySearch extends FakeVersionControl {
    public int firstBadVersion(int n) {

        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1))
                    return mid;
                else
                    hi = mid - 1;
            } else
                lo = mid + 1;
        }

        return n;
    }
}