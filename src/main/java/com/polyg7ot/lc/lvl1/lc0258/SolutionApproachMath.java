/**
 * https://leetcode.com/problems/add-digits/
 */
package com.polyg7ot.lc.lvl1.lc0258;

public class SolutionApproachMath {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}