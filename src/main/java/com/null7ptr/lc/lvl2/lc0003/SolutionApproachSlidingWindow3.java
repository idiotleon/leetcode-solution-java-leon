/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.null7ptr.lc.lvl2.lc0003;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachSlidingWindow3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        int left = 0, right = 0, len = 0, threshold = 0;
        
        while(right < s.length()){
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if(freq.get(c) > 1){
                threshold++;
            }
            right++;
            
            while(threshold > 0){
                char temp = s.charAt(left);
                if(freq.get(temp) > 1){
                    threshold--;
                }
                freq.put(temp, freq.get(temp) - 1);
                left++;
            }
            
            len = Math.max(len, right - left);
        }
        
        return len;
    }
}