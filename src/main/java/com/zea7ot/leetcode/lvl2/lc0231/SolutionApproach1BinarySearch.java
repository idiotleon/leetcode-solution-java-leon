/**
 * https://leetcode.com/problems/power-of-two/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0231;

public class SolutionApproach1BinarySearch {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        
        while(n % 2 == 0){
            n /= 2;
        }
        
        return n == 1;
    }
}