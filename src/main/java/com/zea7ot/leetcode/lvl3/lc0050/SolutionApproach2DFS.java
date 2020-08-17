/**
 * https://leetcode.com/problems/powx-n/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0050;

public class SolutionApproach2DFS {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE && x > 1)
            return 0;

        if (n == 0)
            return 1;

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}