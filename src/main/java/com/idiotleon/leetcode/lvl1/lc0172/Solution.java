package com.idiotleon.leetcode.lvl1.lc0172;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 *
 * Time Complexity:     O(log`n`)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
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