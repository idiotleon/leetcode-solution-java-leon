/**
 * https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.idiotleon.leetcode.lvl3.lc1003;

public class SolutionApproachStack {
    public boolean isValid(String S) {
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < S.length(); i++){
            builder.append(S.charAt(i));
            
            // to remove any "abc" ever possibly
            while(builder.length() > 2 
                  && builder.substring(builder.length() - 3).equals("abc")){
                
                for(int j = 0; j < 3; j++){
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        }
        
        // to see whether the input can be completed removed with the pattern "abc"
        return builder.length() == 0;
    }
}