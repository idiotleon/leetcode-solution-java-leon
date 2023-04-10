/**
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 *
 * Time Complexity:     O(`L`)
 * Space Complexity:    O(`L`) / O(1)
 *
 * 2 passes
 *
 * References:
 *  https://leetcode.com/problems/shortest-distance-to-a-character/discuss/125788/C%2B%2BJavaPython-2-Pass-with-Explanation
 */
package com.idiotleon.leetcode.lvl2.lc0821;

public class SolutionApproach0LinearScan {
    public int[] shortestToChar(String str, final char CH) {
        final int L = str.length();
        final char[] CHS = str.toCharArray();

        int[] ans = new int[L];
        int pos = -L;

        for (int i = 0; i < L; ++i) {
            if (CHS[i] == CH)
                pos = i;
            ans[i] = i - pos;
        }

        for (int i = pos - 1; i >= 0; --i) {
            if (CHS[i] == CH)
                pos = i;
            ans[i] = Math.min(ans[i], pos - i);
        }

        return ans;
    }
}
