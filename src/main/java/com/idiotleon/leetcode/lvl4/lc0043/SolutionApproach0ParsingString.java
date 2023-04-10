package com.idiotleon.leetcode.lvl4.lc0043;

import com.idiotleon.util.Constant;

/**
 * https://leetcode.com/problems/multiply-strings/
 * <p>
 * Time Complexity:     O(L1 + L2)
 * Space Complexity:    O(L1 + L2)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0ParsingString {
    public String multiply(String num1, String num2) {
        final int L1 = num1.length(), L2 = num2.length();
        final char[] CHS1 = num1.toCharArray();
        final char[] CHS2 = num2.toCharArray();
        int[] pos = new int[L1 + L2];

        for (int i = L1 - 1; i >= 0; --i) {
            for (int j = L2 - 1; j >= 0; --j) {
                int mul = (CHS1[i] - '0') * (CHS2[j] - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int p : pos) {
            if (!(builder.length() == 0 && p == 0))
                builder.append(p);
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }
}