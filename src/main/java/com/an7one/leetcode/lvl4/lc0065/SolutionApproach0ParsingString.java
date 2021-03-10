/**
 * https://leetcode.com/problems/valid-number/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/valid-number/discuss/23738/Clear-Java-solution-with-ifs
 */
package com.an7one.leetcode.lvl4.lc0065;

public class SolutionApproach0ParsingString {
    public boolean isNumber(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return false;

        s = s.trim();

        boolean signSeen = false;
        boolean digitSeen = false;
        boolean expSeen = false;
        boolean dotSeen = false;
        boolean digitSeenAfterExp = false;

        char prev = ' ';

        for (char ch : s.toCharArray()) {
            if (ch == '+' || ch == '-') {
                if ((signSeen || digitSeen || dotSeen) && prev != 'e')
                    return false;
                signSeen = true;
            } else if (ch == '.') {
                if (dotSeen || expSeen)
                    return false;
                dotSeen = true;
            } else if (ch == 'e') {
                if (expSeen || !digitSeen)
                    return false;
                expSeen = true;
            } else if (ch >= '0' && ch <= '9') {
                if (expSeen)
                    digitSeenAfterExp = true;
                digitSeen = true;
            } else
                return false;

            prev = ch;
        }

        if (!digitSeen)
            return false;
        if (expSeen && !digitSeenAfterExp)
            return false;

        return true;
    }
}