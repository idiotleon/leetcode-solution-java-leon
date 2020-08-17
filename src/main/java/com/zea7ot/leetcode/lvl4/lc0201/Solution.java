/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 */
package com.zea7ot.leetcode.lvl4.lc0201;

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        for(; m != n; ++i){
            m >>= 1;
            n >>= 1;
        }
        
        return n << i;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while(m < n){
            n = n & (n - 1);
        }
        
        return n;
    }
}