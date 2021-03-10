/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.an7one.leetcode.lvl2.lc0168;

public class SolutionApproach0DFSRecursive {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char) ((n - 1) % 26 + 'A');
    }
}