/**
 * https://leetcode.com/problems/ugly-number/
 * 
 * Time Complexity:     O(n)
 * Space Complexity:    O(1)
 */
package com.polyg7ot.lc.lvl2.lc0263;

public class SolutionApproach0Iteration {
    public boolean isUgly(int num) {
        // sanity check
        if(num <= 0) return false;
        
        while(num % 2 == 0) num /= 2;
        while(num % 3 == 0) num /= 3;
        while(num % 5 == 0) num /= 5;
        
        return num == 1;
    }
}