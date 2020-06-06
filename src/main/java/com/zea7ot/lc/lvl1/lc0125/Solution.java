/**
 * https://leetcode.com/problems/valid-palindrome/
 */
package com.zea7ot.lc.lvl1.lc0125;

public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        while(left < right){
            while(!isAlphanumeric(s.charAt(left))){
                left++;
                if(left == s.length()) return true;
            }
            
            while(!isAlphanumeric(s.charAt(right))) right--;
            if(Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) return false;
        }
        
        return true;
    }
    
    private boolean isAlphanumeric(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    }
}