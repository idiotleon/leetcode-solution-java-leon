/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-two-integers/discuss/132479/Simple-explanation-on-how-to-arrive-at-the-solution
 *  https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary%3A-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
 */
package com.zea7ot.lc.lvl2.lc0371;

public class SolutionApproach0BitManipulation {
    public int getSum(int a, int b) {
        int c;

        while (b != 0) {
            c = (a & b);
            a = a ^ b;
            b = (c << 1);
        }

        return a;
    }
}