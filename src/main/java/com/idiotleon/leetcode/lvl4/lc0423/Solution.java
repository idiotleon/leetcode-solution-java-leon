/**
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.idiotleon.leetcode.lvl4.lc0423;

import java.util.Collections;

public class Solution {
    public String originalDigits(String s) {
        if(s == null || s.length() == 0) return "";
        
        String ans = "";
        
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            ++freq[s.charAt(i) - 'a'];
        }
        
        // to start with special characters
        int[] digits = new int[10];
        digits[0] = freq['z' - 'a'];
        digits[2] = freq['w' - 'a'];
        digits[4] = freq['u' - 'a'];
        digits[6] = freq['x' - 'a'];
        digits[8] = freq['g' - 'a'];
        digits[7] = freq['s' - 'a'] - digits[6];
        digits[3] = freq['h' - 'a'] - digits[8];
        digits[5] = freq['f' - 'a'] - digits[4];
        digits[1] = freq['o' - 'a'] - digits[0] - digits[2] - digits[4];
        digits[9] = freq['i' - 'a'] - digits[5] - digits[6] - digits[8];
        
        for(int i = 0; i < 10; i++){
            if(digits[i] > 0){
                ans += String.join("", Collections.nCopies(digits[i], Character.toString((char) (i + '0'))));
            }
        }
        
        return ans;
    }
}