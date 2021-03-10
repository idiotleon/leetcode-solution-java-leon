/**
 * https://leetcode.com/problems/powx-n/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(lg(N))
 */
package com.an7one.leetcode.lvl3.lc0050;

public class SolutionApproach1DFS {
    public double myPow(double x, int n) {
        if (n < 0)
            return 1 / x * myPow(1 / x, -(n + 1));
        if (n == 0)
            return 1;
        if (n == 2)
            return x * x;
        if (n % 2 == 0)
            return myPow(myPow(x, n / 2), 2);
        else
            return x * myPow(myPow(x, n / 2), 2);
    }
}