/**
 * https://leetcode.com/problems/length-of-last-word/
 */
package com.zea7ot.leetcode.lvl1.lc0058;

public class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;    
    }
}