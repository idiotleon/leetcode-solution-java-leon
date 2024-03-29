package com.idiotleon.leetcode.lvl1.lc0066;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/plus-one/">source</a>
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution {
    public int[] plusOne(int[] digits) {
        final int N = digits.length;
        
        for(int i = N - 1; i >= 0; i--){
            if(digits[i] < 9){
                ++digits[i];
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] newNumber = new int[N + 1];
        newNumber[0] = 1;
        
        return newNumber;
    }
}