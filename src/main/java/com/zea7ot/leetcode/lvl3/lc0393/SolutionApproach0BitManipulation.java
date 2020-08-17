/**
 * https://leetcode.com/problems/utf-8-validation/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/utf-8-validation/discuss/145982/Java-Code-one-loop-and-bit-shift
 *  https://leetcode.com/problems/utf-8-validation/discuss/87464/Bit-Manipulation-Java-6ms
 *  https://leetcode.com/problems/utf-8-validation/discuss/87464/Bit-Manipulation-Java-6ms/92375
 */
package com.zea7ot.leetcode.lvl3.lc0393;

public class SolutionApproach0BitManipulation {
    public boolean validUtf8(int[] data) {
        int bytesRemaining = 0;
        for (int num : data) {
            if (bytesRemaining == 0) {
                if ((num >> 5) == 0b110)
                    bytesRemaining = 1;
                else if ((num >> 4) == 0b1110)
                    bytesRemaining = 2;
                else if ((num >> 3) == 0b11110)
                    bytesRemaining = 3;
                else if ((num >> 7) != 0)
                    return false;
            } else {
                if ((num >> 6) != 0b10)
                    return false;
                --bytesRemaining;
            }
        }

        return bytesRemaining == 0;
    }
}