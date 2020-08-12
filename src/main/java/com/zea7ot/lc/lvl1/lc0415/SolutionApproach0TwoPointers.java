/**
 * https://leetcode.com/problems/add-strings/
 * 
 * Time Complexity:     O(max(L1, L2))
 * Space Complexity:    O(max(L1, L2))
 */
package com.zea7ot.lc.lvl1.lc0415;

public class SolutionApproach0TwoPointers {
    public String addStrings(String num1, String num2) {
        final int L1 = num1.length(), L2 = num2.length();
        if (L1 == 0)
            return num2;
        if (L2 == 0)
            return num1;
        if (L1 < L2)
            return addStrings(num2, num1);

        StringBuilder builder = new StringBuilder();
        int idx1 = L1 - 1, idx2 = L2 - 1, carry = 0;
        while (idx1 >= 0) {
            int n1 = num1.charAt(idx1) - '0';
            int n2 = (idx2 >= 0) ? num2.charAt(idx2) - '0' : 0;

            int sum = n1 + n2 + carry;
            carry = sum / 10;
            builder.insert(0, sum % 10);

            --idx1;
            --idx2;
        }

        if (carry > 0)
            builder.insert(0, "1");

        return builder.toString();
    }
}