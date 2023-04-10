/**
 * @author: Leon
 * https://leetcode.com/problems/compare-version-numbers/
 * 
 * Time Complexity:     O(max(L1, L2))
 * Space Compleity:     O(max(L1, L2))
 */
package com.idiotleon.leetcode.lvl2.lc0165;

public class SolutionApproach0LinearScan {
    public int compareVersion(String version1, String version2) {
        final String[] VER1 = version1.split("\\.");
        final int N1 = VER1.length;

        final String[] VER2 = version2.split("\\.");
        final int N2 = VER2.length;

        int idx = 0;
        while (idx < Math.max(N1, N2)) {
            int num1 = idx < N1 ? Integer.parseInt(VER1[idx]) : 0;
            int num2 = idx < N2 ? Integer.parseInt(VER2[idx]) : 0;

            if (num1 == num2) {
                ++idx;
            } else if (num1 > num2)
                return 1;
            else
                return -1;
        }

        return 0;
    }
}
