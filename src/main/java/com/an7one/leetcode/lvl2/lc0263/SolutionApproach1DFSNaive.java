/**
 * https://leetcode.com/problems/ugly-number/
 * 
 * Time Complexity:     O(lg(`num`))
 * Space Complexity:    O(lg(`num`))
 * 
 * References:
 *  https://leetcode.com/problems/ugly-number/discuss/69332/Simple-java-solution-with-explanation
 */
package com.an7one.leetcode.lvl2.lc0263;

public class SolutionApproach1DFSNaive {
    public boolean isUgly(int num) {
        if (num == 0)
            return false;
        if (num == 1)
            return true;

        if (num % 2 == 0)
            return isUgly(num / 2);
        if (num % 3 == 0)
            return isUgly(num / 3);
        if (num % 5 == 0)
            return isUgly(num / 5);

        return false;
    }
}