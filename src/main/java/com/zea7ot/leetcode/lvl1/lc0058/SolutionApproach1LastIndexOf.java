/**
 * https://leetcode.com/problems/length-of-last-word/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc0058;

public class SolutionApproach1LastIndexOf {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}