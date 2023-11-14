package com.idiotleon.leetcode.lvl3.lc0050;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/powx-n/">LC0050</a>
 * <p>
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 * <p>
 * Reference:
 * <a href="https://leetcode.wang/leetCode-50-Pow.html">LCDiscussion</a>
 * <a href="https://leetcode.com/problems/powx-n/discuss/19563/Iterative-Log(N)-solution-with-Clear-Explanation">LCDiscussion</a>
 * <a href="https://leetcode.com/problems/powx-n/discuss/19563/Iterative-Log(N)-solution-with-Clear-Explanation/115437">LCDiscussion</a>
 * <a href="https://stackoverflow.com/questions/38922606/what-is-x-1-and-x-1">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BinarySearch {
    public double myPow(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long) n);

        while (absN > 0) {
            if ((absN & 1) == 1) {
                ans *= x;
            }
            absN >>= 1;
            x *= x;
        }

        return n < 0 ? 1 / ans : ans;
    }
}
