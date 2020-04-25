/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
package com.null7ptr.lc.lvl3.lc0151;

public class SolutionApproachTwoPtrs {
    public String reverseWords(String str) {
        StringBuilder builder = trimSpace(str);
        reverse(builder, 0, builder.length() - 1);
        reverseEachWord(builder);
        return builder.toString();
    }
    
    private StringBuilder trimSpace(String str){
        int left = 0, right = str.length() - 1;
        // to remove leading spaces
        while(left <= right && str.charAt(left) == ' ') ++left;
        // to remove trailing spaces
        while(left <= right && str.charAt(right) == ' ') --right;
        
        // to reduce multiple spaces to a single one
        StringBuilder builder = new StringBuilder();
        while(left <= right){
            char c = str.charAt(left);
            
            if(c != ' ') builder.append(c);
            else if(builder.charAt(builder.length() - 1) != ' ') 
                builder.append(c);
            
            ++left;
        }
        
        return builder;
    }
    
    private void reverseEachWord(StringBuilder builder){
        int n = builder.length(), start = 0, end = 0;
        
        while(start < n){
            while(end < n && builder.charAt(end) != ' ') ++end;
            reverse(builder, start, end - 1);
            start = end + 1;
            ++end;
        }
    }
    
    private void reverse(StringBuilder stringBuilder, int left, int right){
        while(left < right){
            char temp = stringBuilder.charAt(left);
            stringBuilder.setCharAt(left++, stringBuilder.charAt(right));
            stringBuilder.setCharAt(right--, temp);
        }
    }
}