/**
 * https://leetcode.com/problems/divide-two-integers/
 */
package com.null7ptr.lc.lvl3.lc0029;

public class Solution{
    public int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }
    
    private long divideLong(long dividend, long divisor){
        
        // to remember the sign
        boolean negative = dividend < 0 != divisor < 0;
        
        // to make dividend and divisor unsign
        if(dividend < 0) dividend = -dividend;
        if(divisor < 0) divisor = -divisor;
        
        // to return if nothing to divide
        if(dividend < divisor) return 0;
        
        // to sum divisor 2, 4, 8, 16, 32, ... times
        long sum = divisor;
        long divide = 1;
        while((sum + sum) <= dividend){
            sum += sum;
            divide += divide;
        }
        
        // to make a recursive call for (devided - sum) and add it to the result
        return negative ? -(divide + divideLong((dividend - sum), divisor)) : (divide + divideLong((dividend - sum), divisor));
    }
}