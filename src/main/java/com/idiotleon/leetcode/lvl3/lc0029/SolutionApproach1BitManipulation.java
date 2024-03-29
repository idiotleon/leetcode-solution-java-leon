package com.idiotleon.leetcode.lvl3.lc0029;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/divide-two-integers/">LC0029</a>
 * <p>
 * Time Complexity:     O(32) ~ O(1)
 * Space Complexity:    O(1)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/divide-two-integers/discuss/142849/C%2B%2BJavaPython-Should-Not-Use-%22long%22-Int">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1BitManipulation {
    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) {
            return (1 << 31) - 1;
        }

        int a = Math.abs(dividend), b = Math.abs(divisor);
        int ans = 0;

        for (int count = 31; count >= 0; --count) {
            if ((a >>> count) - b >= 0) {
                ans += 1 << count;
                a -= b << count;
            }
        }

        return (dividend > 0) == (divisor > 0) ? ans : -ans;
    }
}