package com.idiotleon.leetcode.lvl3.lc0029;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/divide-two-integers/">LC0029</a>
 * <p>
 * Time Complexity:     O((lg(dividend)) ^ 2)
 * Space Complexity:    O(1)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/divide-two-integers/discuss/142849/C%2B%2BJavaPython-Should-Not-Use-%22long%22-Int">LC Discussion</a>
 * <a href="https://youtu.be/htX69j1jf5U">Youtube</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BinarySearch {
    public int divide(int dividend, int divisor) {
        // to prevent stack overflow
        // 1 << 31 is Integer.MIN_VALUE
        if (dividend == 1 << 31 && divisor == -1)
            return (1 << 31) - 1;
        int a = Math.abs(dividend), b = Math.abs(divisor);
        int ans = 0, count = 0;
        while (a - b >= 0) {
            for (count = 0; a - (b << 1 << count) >= 0; count++) ;
            ans += 1 << count;
            a -= b << count;
        }

        return (dividend > 0) == (divisor > 0) ? ans : -ans;
    }
}