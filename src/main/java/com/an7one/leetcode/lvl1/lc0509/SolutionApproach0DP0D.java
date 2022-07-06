package com.an7one.leetcode.lvl1.lc0509;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/fibonacci-number/">LC0509</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/fibonacci-number/discuss/215992/Java-Solutions">LC Discusion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP0D {
    public int fib(int N) {
        if (N <= 1)
            return N;

        int prev = 0, cur = 1;

        int steps = 1;
        while (steps < N) {
            int sum = prev + cur;
            prev = cur;
            cur = sum;

            ++steps;
        }

        return cur;
    }
}