/**
 * https://leetcode.com/problems/add-digits/
 * 
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl1.lc0258;

public class SolutionApproach0Math {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}