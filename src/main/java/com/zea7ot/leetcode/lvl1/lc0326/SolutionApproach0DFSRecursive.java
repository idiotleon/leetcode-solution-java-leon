/**
 * https://leetcode.com/problems/power-of-three/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/power-of-three/discuss/77876/**-A-summary-of-all-solutions-(new-method-included-at-15%3A30pm-Jan-8th)
 */
package com.zea7ot.leetcode.lvl1.lc0326;

public class SolutionApproach0DFSRecursive {
    public boolean isPowerOfThree(int n) {
        return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree(n / 3)));
    }
}
