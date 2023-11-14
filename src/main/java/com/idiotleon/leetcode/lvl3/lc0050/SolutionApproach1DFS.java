package com.idiotleon.leetcode.lvl3.lc0050;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/powx-n/">LC0050</a>
 * <p>
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(lg(N))
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DFS {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        }

        if (n == 0) {
            return 1;
        }

        if (n == 2) {
            return x * x;
        }

        if (n % 2 == 0) {
            return myPow(myPow(x, n / 2), 2);
        } else {
            return x * myPow(myPow(x, n / 2), 2);
        }
    }
}