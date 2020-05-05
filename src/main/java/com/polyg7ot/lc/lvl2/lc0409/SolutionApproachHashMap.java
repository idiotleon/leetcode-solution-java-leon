/**
 * https://leetcode.com/problems/longest-palindrome/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.polyg7ot.lc.lvl2.lc0409;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproachHashMap {
    public int longestPalindrome(String str) {
        if(str == null || str.length() == 0) return 0;
        Set<Character> set = new HashSet<Character>();
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(set.contains(str.charAt(i))){
                set.remove(str.charAt(i));
                count++;
            }else{
                set.add(str.charAt(i));
            }
        }
        
        if(!set.isEmpty()) return count * 2 + 1;
        return count * 2;
    }

    public int longestPalindrome2(String str) {
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        
        int res = 0;
        for(int i = 0; i < str.length(); i++){
            char cur = str.charAt(i);
            if(cur >= 'a' && cur <= 'z') lowercase[cur - 'a']++;
            else uppercase[cur - 'A']++;
        }
        
        for(int i = 0; i < 26; i++){
            res += (lowercase[i] / 2) * 2;
            res += (uppercase[i] / 2) * 2;
        }
        
        // can only have one char with odd numbers
        return res == str.length() ? res : res + 1;
    }
}