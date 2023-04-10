/**
 * https://leetcode.com/problems/palindrome-permutation-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/palindrome-permutation-ii/discuss/69698/Short-backtracking-solution-in-Java-(3-ms)
 */
package com.idiotleon.leetcode.lvl4.lc0267;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if(s == null || s.isEmpty()) return ans;
        
        int[] freq = new int[128];
        for(char c : s.toCharArray()){
            ++freq[c];
        }
        
        int oddCount = 0, halfLen = 0;
        char oddChar = 0;   // impossible char
        for(int i = 0; i < 128; i++){
            if(freq[i] % 2 == 1){
                oddCount++;
                oddChar = (char) i;
            }
            
            freq[i] /= 2;
            halfLen += freq[i];
        }
        
        // cannot tolerate more than one char of odd number
        if(oddCount > 1) return ans;

        backtrack(freq, new StringBuilder(), ans, halfLen, oddChar);
        
        return ans;
    }
    
    private void backtrack(int[] freq,
                           StringBuilder path, 
                           final List<String> PATHS,
                           final int LEN,
                           final char MID_CHAR){
        if(path.length() == LEN){
            StringBuilder builder = new StringBuilder(path);
            if(MID_CHAR != 0) builder.append(MID_CHAR);
            StringBuilder reverse = new StringBuilder(path).reverse();
            builder.append(reverse);
            PATHS.add(builder.toString());
            return;
        }
        
        for(int i = 0; i < 128; i++){
            if(freq[i] > 0){
                freq[i]--;
                path.append((char) i);
                backtrack(freq, path, PATHS, LEN, MID_CHAR);
                path.deleteCharAt(path.length() - 1);
                freq[i]++;
            }
        }
    }
}