/**
 * https://leetcode.com/problems/arranging-coins/
 * 
 * References:
 *  https://leetcode.com/problems/arranging-coins/discuss/92274/JAVA-Clean-Code-with-Explanations-and-Running-Time-2-Solutions
 */
package com.an7one.leetcode.lvl2.lc0441;

public class SolutionApproach0Math {
    public int arrangeCoins(int n) {
        int i = 0;
        while(n > 0){
            i += 1;
            n -= i;
        }
        
        return n == 0 ? i : i - 1;
    }
}