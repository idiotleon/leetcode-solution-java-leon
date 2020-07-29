/**
 * https://leetcode.com/problems/nth-digit/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/nth-digit/discuss/88363/Java-solution
 */
package com.zea7ot.lc.lvl3.lc0400;

public class SolutionApproach0Math {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;
        
        while(n > len * count){
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }
        
        start += (n - 1) / len;
        String str = Integer.toString(start);
        return Character.getNumericValue(str.charAt((n - 1) % len));
    }
}