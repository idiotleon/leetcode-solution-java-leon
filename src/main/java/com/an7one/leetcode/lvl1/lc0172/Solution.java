/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 * 
 * Time Complexity: O(logn)
 * 
 * Space Complexity: O(1)
 */
package com.an7one.leetcode.lvl1.lc0172;

public class Solution {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        long currentMultiple = 5;
        
        while(n > 0){
            n /= currentMultiple;
            zeroCount += n;
        }
        
        return zeroCount;
    }
}