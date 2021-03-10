/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.an7one.leetcode.lvl2.lc0168;

class SolutionApproach0Iteration {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();

        while (n != 0) {
            char ch = (char) ((n - 1) % 26 + 'A');
            n = (n - 1) / 26;
            builder.insert(0, ch);
        }

        return builder.toString();
    }
}