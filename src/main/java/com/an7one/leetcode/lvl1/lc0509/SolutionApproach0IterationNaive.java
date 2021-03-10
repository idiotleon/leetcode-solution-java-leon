/**
 * https://leetcode.com/problems/fibonacci-number/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/fibonacci-number/discuss/215992/Java-Solutions
 */
package com.an7one.leetcode.lvl1.lc0509;

public class SolutionApproach0IterationNaive {
    public int fib(int N) {
        if (N <= 1)
            return N;

        int a = 0, b = 1;

        int steps = 1;
        while (steps < N) {
            int sum = a + b;
            a = b;
            b = sum;

            ++steps;
        }

        return b;
    }
}