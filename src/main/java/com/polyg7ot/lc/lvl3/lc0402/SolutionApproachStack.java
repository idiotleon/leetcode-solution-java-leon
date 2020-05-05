/**
 * https://leetcode.com/problems/remove-k-digits/
 * 
 * Time Complexity: O(N)
 * to remove the last char is considered constant time, 
 * because no shifting elements is involved
 * 
 * Space Complexity: O(N)
 */
package com.polyg7ot.lc.lvl3.lc0402;

public class SolutionApproachStack {
    public String removeKdigits(String num, int k) {
        StringBuilder builder = new StringBuilder();
        final int L = num.length();
        for(int i = 0; i < L; i++){
            while(builder.length() > 0 
                  && builder.charAt(builder.length() - 1) > num.charAt(i)
                  && k > 0){
                builder.deleteCharAt(builder.length() - 1);
                k--;
            }
            
            if(builder.length() > 0 || num.charAt(i) != '0'){
                builder.append(num.charAt(i));
            }
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