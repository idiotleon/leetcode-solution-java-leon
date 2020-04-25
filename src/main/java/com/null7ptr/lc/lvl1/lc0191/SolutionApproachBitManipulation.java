/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
package com.null7ptr.lc.lvl1.lc0191;

public class SolutionApproachBitManipulation{
    public int hammingWeight(int n) {
        int ones = 0;
        while(n != 0){
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        
        return ones;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        
        return count;
    }
}