/**
 * https://leetcode.com/problems/ugly-number-iii/
 * 
 * Time Complexity:     O(lg(`RANGE`))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/ugly-number-iii/discuss/387780/JavaC%2B%2B-Binary-Search-with-Venn-Diagram-Explain-Math-Formula
 */
package com.an7one.leetcode.lvl3.lc1201;

public class SolutionApproach0BinarySearch {
    public int nthUglyNumber(int n, int a, int b, int c) {
        final int RANGE = Integer.MAX_VALUE;
        int lo = 1, hi = RANGE;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (count(a, b, c, mid) < n)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }

    private int count(long a, long b, long c, long num) {
        long ab = lcm(a, b);
        long ac = lcm(a, c);
        long bc = lcm(b, c);
        long abc = lcm(a, bc);
        return (int) ((num / a) + (num / b) + (num / c) - (num / ab) - (num / bc) - (num / ac) + (num / abc));
    }

    // Least Common Multiple 最小公倍数
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    // Greatest Common Divisor 最大公约数
    private long gcd(long a, long b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }
}