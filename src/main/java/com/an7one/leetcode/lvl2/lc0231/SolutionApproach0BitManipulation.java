/**
 * https://leetcode.com/problems/power-of-two/
 * 
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 * 
 * Referenes:
 *  https://leetcode.com/problems/power-of-two/discuss/63966/4-different-ways-to-solve-Iterative-Recursive-Bit-operation-Math
 */
package com.an7one.leetcode.lvl2.lc0231;

import com.an7one.util.Constant;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BitManipulation {
    public boolean isPowerOfTwo(int n) {
        // if(n <= 0) return false;
        
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}