/**
 * https://leetcode.com/problems/hamming-distance/
 * 
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/hamming-distance/discuss/94698/Java-1-Line-Solution-%3AD
 *  https://tech.liuchao.me/2016/11/count-bits-of-integer/
 */
package com.zea7ot.lc.lvl2.lc0461;

public class SolutionApproach0BitManipulation {
    public int hammingDistance(int x, int y) {
        return getHammingWeight(x ^ y);
    }
    
    private int getHammingWeight(int n){
        int count = 0;
        while(n != 0){
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
}