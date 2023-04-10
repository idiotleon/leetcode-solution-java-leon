/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 * 
 * Time Complexity:     O((max(LEN1, LEN2)) ^ 2)
 * Space Complexity:    O(max(LEN1, LEN))
 * 
 * References:
 *  https://leetcode.com/problems/greatest-common-divisor-of-strings/discuss/303781/JavaPython-3-3-codes-each%3A-Recursive-iterative-and-regex-w-brief-comments-and-analysis.
 */
package com.idiotleon.leetcode.lvl2.lc1071;

public class SolutionApproach2Recursion {
    public String gcdOfStrings(String str1, String str2) {
        final int LEN1 = str1.length(), LEN2 = str2.length();
        if (LEN1 < LEN2) {
            return gcdOfStrings(str2, str1);
        } else if (!str1.startsWith(str2)) {
            return "";
        } else if (str2.isEmpty()) {
            return str1;
        } else {
            return gcdOfStrings(str1.substring(LEN2), str2);
        }
    }
}