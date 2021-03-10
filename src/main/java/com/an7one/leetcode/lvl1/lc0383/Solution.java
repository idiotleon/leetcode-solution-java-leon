/**
 * https://leetcode.com/problems/ransom-note/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.an7one.leetcode.lvl1.lc0383;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || ransomNote.length() == 0) return true;
                
        int[] freq = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            ++freq[magazine.charAt(i) - 'a'];
        }
        
        for(int i = 0; i < ransomNote.length(); i++){
            if(--freq[ransomNote.charAt(i) - 'a'] < 0) 
                return false;
        }
        
        return true;
    }
}