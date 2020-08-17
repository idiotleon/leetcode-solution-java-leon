/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.zea7ot.leetcode.lvl3.lc0151;

public class SolutionApproach0TwoPointers {
    public String reverseWords(String str) {
        StringBuilder builder = trimSpace(str);
        reverse(builder, 0, builder.length() - 1);
        reverseEachWord(builder);
        return builder.toString();
    }
    
    private StringBuilder trimSpace(String str){
        final int L = str.length();
        int lo = 0, hi = L - 1;
        // to remove leading spaces
        while(lo <= hi && str.charAt(lo) == ' ') ++lo;
        // to remove trailing spaces
        while(lo <= hi && str.charAt(hi) == ' ') --hi;
        
        // to reduce multiple spaces to a single one
        StringBuilder builder = new StringBuilder(str);
        while(lo <= hi){
            char ch = str.charAt(lo);
            
            if(ch != ' ') builder.append(ch);
            else if(builder.charAt(builder.length() - 1) != ' ') 
                builder.append(ch);
            
            ++lo;
        }
        
        return builder;
    }
    
    private void reverseEachWord(StringBuilder builder){
        final int L = builder.length();
        int start = 0, end = 0;
        
        while(start < L){
            while(end < L && builder.charAt(end) != ' ') ++end;
            reverse(builder, start, end - 1);
            start = end + 1;
            ++end;
        }
    }
    
    private void reverse(StringBuilder builder, int lo, int hi){
        while(lo < hi){
            char ch = builder.charAt(lo);
            builder.setCharAt(lo++, builder.charAt(hi));
            builder.setCharAt(hi--, ch);
        }
    }
}