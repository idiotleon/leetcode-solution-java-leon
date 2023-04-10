/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 * 
 * Time Complexity:     O(32 / 4) ~ O(1)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/convert-a-number-to-hexadecimal/discuss/89253/Simple-Java-solution-with-comment
 */
package com.idiotleon.leetcode.lvl2.lc0405;

public class SolutionApproach0Math {
    private static final char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f' };

    public String toHex(int num) {
        if (num == 0)
            return "0";
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            builder.append(HEX[(num & 15)]);
            num = (num >>> 4);
        }

        return builder.reverse().toString();
    }
}