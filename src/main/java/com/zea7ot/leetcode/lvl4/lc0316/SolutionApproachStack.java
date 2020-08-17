/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * to main a "strickly increasing" stack
 *  1. the contents are actual characters
 *  2. the order of characters is maintained in strictly increasing order, if possible 
 *      by "if possible", it rather depends on the given String sequence,
 *      in another words, how many letters left, and what they are
 */
package com.zea7ot.leetcode.lvl4.lc0316;

public class SolutionApproachStack {
    public String removeDuplicateLetters(String s) {
        // to count remaining character
        int[] remaining = new int[26];
        // to count characters used in the string
        int[] used = new int[26];
        
        final int L = s.length();
        for(int i = 0; i < L; i++){
            ++remaining[s.charAt(i) - 'a'];
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < L; i++){
            if(used[s.charAt(i) - 'a'] == 0){
                // to pop out duplicates and bigger characters existing in the builder
                while(builder.length() > 0
                      && builder.charAt(builder.length() - 1) >= s.charAt(i) 
                      && remaining[builder.charAt(builder.length() - 1) - 'a'] > 0){
                    --used[builder.charAt(builder.length() - 1) - 'a'];
                    builder.deleteCharAt(builder.length() - 1);
                }
                builder.append(s.charAt(i));
                ++used[s.charAt(i) - 'a'];
            }
            --remaining[s.charAt(i) - 'a'];
        }
        
        return builder.toString();
    }
}