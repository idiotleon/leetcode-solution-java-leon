/**
 * https://leetcode.com/problems/remove-k-digits/
 * 
 * Time Complexity: O(N)
 *  to remove the last char is considered constant time, 
 *  because of no shifting elements involved
 * Space Complexity: O(N)
 * 
 * to maintain a "non-decreasing" stack, in the format of StringBuilder
 * 1. the contents of the stack are actual characters
 * 2. the characters are maintained in non-increasing order
 *  since it is to find the smallest possible number, 
 *  non-increasing order is preferred
 */
package com.zea7ot.leetcode.lvl3.lc0402;

public class SolutionApproachStack {
    public String removeKdigits(String num, int k) {
        StringBuilder builder = new StringBuilder();
        final int L = num.length();
        int idx = 0;
        while(idx < L){
            while(builder.length() > 0 
                  // once a "smaller" char has ever been found
                  && builder.charAt(builder.length() - 1) > num.charAt(idx)
                  && k > 0){
                // to pop out the top from the stack
                builder.deleteCharAt(builder.length() - 1);
                k--;
            }
            
            // either that the StringBuilder contains any character,
            // or that the StringBuilder does NOT start with '0'
            if(builder.length() > 0 || num.charAt(idx) != '0'){
                builder.append(num.charAt(idx));
            }

            idx++;
        }
        
        // to pop up the extra digits from end
        while(builder.length() > 0 && k > 0){
            builder.deleteCharAt(builder.length() - 1);
            k--;
        }
        
        if(builder.length() == 0) return "0";
        return builder.toString();
    }
}