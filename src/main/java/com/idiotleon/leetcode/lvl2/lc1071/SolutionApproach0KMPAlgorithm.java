/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 * 
 * Time Complexity:     O(LEN1 + LEN2) ~ O(max(LEN1, LEN2))
 * Space Complexity:    O(LEN1 + LEN2) ~ O(max(LEN1, LEN2))
 */
package com.idiotleon.leetcode.lvl2.lc1071;

public class SolutionApproach0KMPAlgorithm {
    public String gcdOfStrings(String str1, String str2) {
        // santiy check
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty())
            return "";

        final int LEN1 = str1.length(), LEN2 = str2.length();

        final String SEG1 = getRepeatedSegment(str1);
        final String SEG2 = getRepeatedSegment(str2);
        if (!SEG1.equals(SEG2) || SEG2.isEmpty())
            return "";

        // to calculate the greatest common divisor
        int a = LEN1 / SEG1.length();
        int b = LEN2 / SEG2.length();
        final int N = gcd(a, b);

        // to compose the answer
        return repeatNTimes(SEG1, N);
    }

    private int gcd(int a, int b) {
        while (a * b != 0) {
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }

            a = a % b;
        }

        return b;
    }

    private String repeatNTimes(final String SEGMENT, final int N) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            builder.append(SEGMENT);
        }

        return builder.toString();
    }

    // to get the shortest repeated segment if possible
    private String getRepeatedSegment(String str) {
        // sanity check
        if (str == null || str.isEmpty())
            return str;

        final int L = str.length();
        final char[] CHS = str.toCharArray();
        final int[] KMP = new int[L];

        int i = 1, j = 0;
        while (i < L) {
            if (CHS[i] == CHS[j]) {
                KMP[i++] = ++j;
            } else if (j == 0) {
                ++i;
            } else {
                j = KMP[j - 1];
            }
        }

        if ((j > 0) && (L % (L - j) == 0))
            return str.substring(0, L - j);

        return str;
    }
}