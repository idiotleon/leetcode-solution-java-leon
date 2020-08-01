/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  
 */
package com.zea7ot.lc.lvl3.lc0005;

public class SolutionApproach0ExpandPalindrome1 {
    public String longestPalindrome(String s) {
        // sanity check
        if(s == null || s.length() < 2) return s;
        
        final int L = s.length();
        char[] chs = s.toCharArray();
        
        int start = 0, end = 0;
        for(int i = 0; i < L; ++i){
            int len1 = expand(i, i, chs);
            int len2 = expand(i, i + 1, chs);
            int len = Math.max(len1, len2);
            
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int expand(int lo, int hi, char[] chs){
        final int L = chs.length;
        while(lo >= 0 && hi < L && chs[lo] == chs[hi]){
            --lo;
            ++hi;
        }
        
        return hi - lo - 1;
    }
}