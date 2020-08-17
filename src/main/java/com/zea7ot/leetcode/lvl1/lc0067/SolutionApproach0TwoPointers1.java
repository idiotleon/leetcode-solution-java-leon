/**
 * https://leetcode.com/problems/add-binary/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.zea7ot.leetcode.lvl1.lc0067;

public class SolutionApproach0TwoPointers1 {

    public String addBinary2(String a, String b) {
        // sanity checks
        if (a == null || a.isEmpty())
            return b;
        if (b == null || b.isEmpty())
            return a;

        final int LEN_A = a.length(), LEN_B = b.length();
        final char[] CHS_A = a.toCharArray(), CHS_B = b.toCharArray();
        int idx = 0, carry = 0;
        StringBuilder builder = new StringBuilder();

        while (idx < LEN_A || idx < LEN_B || carry != 0) {
            int x = (idx < LEN_A) ? CHS_A[LEN_A - 1 - idx] - '0' : 0;
            int y = (idx < LEN_B) ? CHS_B[LEN_B - 1 - idx] - '0' : 0;
            int sum = x + y + carry;
            builder.append(sum % 2);
            carry = sum / 2;
            ++idx;
        }

        return builder.reverse().toString();
    }
}