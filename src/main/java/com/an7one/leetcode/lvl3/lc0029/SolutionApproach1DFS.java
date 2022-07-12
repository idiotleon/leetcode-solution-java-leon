package com.an7one.leetcode.lvl3.lc0029;

import com.an7one.util.Constant;

/**
 * <a href="https://leetcode.com/problems/divide-two-integers/">LC0029</a>
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DFS {
    public int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }

    private long divideLong(long dividend, long divisor) {
        // to remember the sign
        boolean negative = dividend < 0 != divisor < 0;

        // to make dividend and divisor unsigned
        if (dividend < 0)
            dividend = -dividend;
        if (divisor < 0)
            divisor = -divisor;

        // to return if nothing to divide
        if (dividend < divisor)
            return 0;

        // to sum divisor 2, 4, 8, 16, 32, ... times
        long sum = divisor;
        long divide = 1;
        while ((sum + sum) <= dividend) {
            sum += sum;
            divide += divide;
        }

        // to make a recursive call for (dividend - sum) and add it to the result
        return negative ? -(divide + divideLong((dividend - sum), divisor))
                : (divide + divideLong((dividend - sum), divisor));
    }
}