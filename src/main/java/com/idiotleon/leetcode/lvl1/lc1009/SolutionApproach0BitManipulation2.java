/**
 * https://leetcode.com/problems/complement-of-base-10-integer/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/complement-of-base-10-integer/discuss/613118/4-approaches%3A-bitwise-operation-math-formular-one-naive-simulation-and-bonus
 */
package com.idiotleon.leetcode.lvl1.lc1009;

public class SolutionApproach0BitManipulation2 {
    public int bitwiseComplement(int num) {
        if (num == 0)
            return 1;
        int mask = num;

        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;
        return num ^ mask;
    }
}
