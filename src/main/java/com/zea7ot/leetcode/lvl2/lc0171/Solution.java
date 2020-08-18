/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L)
 */
package com.zea7ot.leetcode.lvl2.lc0171;

public class Solution {
    public int titleToNumber(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        char[] chs = s.toCharArray();

        int ans = 0;
        for (int i = 0; i < L; ++i) {
            ans = ans * 26 + (chs[i] - 'A' + 1);
        }

        return ans;
    }
}