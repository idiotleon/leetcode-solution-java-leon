/**
 * https://leetcode.com/problems/length-of-last-word/
 */

package main.java.lcidiot.lc0058;

class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;    
    }
}