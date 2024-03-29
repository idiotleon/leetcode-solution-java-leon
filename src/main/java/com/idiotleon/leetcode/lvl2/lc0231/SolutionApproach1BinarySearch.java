/**
 * https://leetcode.com/problems/power-of-two/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl2.lc0231;

import com.idiotleon.util.Constant;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1BinarySearch {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        
        while(n % 2 == 0){
            n /= 2;
        }
        
        return n == 1;
    }
}