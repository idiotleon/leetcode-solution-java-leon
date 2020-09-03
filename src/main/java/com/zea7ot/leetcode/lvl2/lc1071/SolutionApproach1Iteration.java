/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 * 
 * Time Complexity:     O(max(LEN1, LEN2))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/greatest-common-divisor-of-strings/discuss/303781/JavaPython-3-3-codes-each%3A-Recursive-iterative-and-regex-w-brief-comments-and-analysis.
 */
package com.zea7ot.leetcode.lvl2.lc1071;

public class SolutionApproach1Iteration {
    public String gcdOfStrings(String str1, String str2) {
        final int LEN1 = str1.length(), LEN2 = str2.length();
        int d = greatestCommonDivisor(LEN1, LEN2);

        String sub = str1.substring(0, d), str = str1 + str2;
        for (int i = 0; i < LEN1 + LEN2; i += d) {
            if (!str.startsWith(sub, i)) {
                return "";
            }
        }

        return sub;
    }

    private int greatestCommonDivisor(int a, int b) {
        return a == 0 ? b : greatestCommonDivisor(b % a, a);
    }
}