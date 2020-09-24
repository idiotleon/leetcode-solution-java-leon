/**
 * https://leetcode.com/problems/powx-n/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.wang/leetCode-50-Pow.html
 *  https://leetcode.com/problems/powx-n/discuss/19563/Iterative-Log(N)-solution-with-Clear-Explanation
 *  https://leetcode.com/problems/powx-n/discuss/19563/Iterative-Log(N)-solution-with-Clear-Explanation/115437
 *  https://stackoverflow.com/questions/38922606/what-is-x-1-and-x-1
 */
package com.zea7ot.leetcode.lvl3.lc0050;

public class SolutionApproach0IterationWithBitManipulation {
    public double myPow(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long) n);

        while (absN > 0) {
            if ((absN & 1) == 1)
                ans *= x;
            absN >>= 1;
            x *= x;
        }

        return n < 0 ? 1 / ans : ans;
    }
}
