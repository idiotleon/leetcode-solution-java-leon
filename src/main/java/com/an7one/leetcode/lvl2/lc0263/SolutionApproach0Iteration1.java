/**
 * https://leetcode.com/problems/ugly-number/
 * 
 * Time Complexity:     O(lg(`num`))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/ugly-number/discuss/69332/Simple-java-solution-with-explanation/533043
 */
package com.an7one.leetcode.lvl2.lc0263;

public class SolutionApproach0Iteration1 {
    public boolean isUgly(int num) {
        // sanity check
        if (num <= 0)
            return false;

        int[] factors = { 2, 3, 5 };
        int k = 0;
        while (k < 3) {
            if (num % factors[k] == 0) {
                num /= factors[k];
            } else {
                ++k;
            }
        }

        return num == 1;
    }
}