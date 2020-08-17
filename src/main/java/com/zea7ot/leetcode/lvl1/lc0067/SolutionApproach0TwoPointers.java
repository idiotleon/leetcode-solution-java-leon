/**
 * https://leetcode.com/problems/add-binary/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.zea7ot.leetcode.lvl1.lc0067;

public class SolutionApproach0TwoPointers {
    public String addBinary(String a, String b) {
        // sanity checks
        if (a == null || a.isEmpty())
            return b;
        if (b == null || b.isEmpty())
            return a;

        final int LEN_A = a.length(), LEN_B = b.length();
        final char[] CHS_A = a.toCharArray(), CHS_B = b.toCharArray();
        int idxA = LEN_A - 1, idxB = LEN_B - 1;

        StringBuilder builder = new StringBuilder();
        int carry = 0;
        while (idxA >= 0 || idxB >= 0) {
            int sum = carry;
            if (idxA >= 0)
                sum += CHS_A[idxA] - '0';
            if (idxB >= 0)
                sum += CHS_B[idxB] - '0';
            builder.append(sum % 2);
            carry = sum / 2;

            --idxA;
            --idxB;
        }

        if (carry > 0)
            builder.append(carry);

        return builder.reverse().toString();
    }
}