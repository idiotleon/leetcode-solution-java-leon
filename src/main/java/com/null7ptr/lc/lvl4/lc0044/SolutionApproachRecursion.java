/**
 * https://leetcode.com/problems/wildcard-matching/
 * 
 * https://www.youtube.com/watch?v=3ZDZ-N0EPV0&t=121s
 */
package com.null7ptr.lc.lvl4.lc0044;

class SolutionApproachRecursion{
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
    }
    
    private boolean isMatch(char[] text, char[] pattern, int pos1, int pos2){
        if(pos2 == pattern.length) return text.length == pos1;
        
        if(pattern[pos2] != '*'){
            if(pos1 < text.length && (text[pos1] == pattern[pos2] || pattern[pos2] == '?')) 
                return isMatch(text, pattern, pos1 + 1, pos2 + 1);
            else return false;
        }else{
            while(pos2 < pattern.length - 1 && pattern[pos2 + 1] == '*') pos2++;
            pos1--;
            while(pos1 < text.length){
                if(isMatch(text, pattern, pos1 + 1, pos2 + 1)) return true;
                pos1++;
            }
        }
        
        return false;
    }
}