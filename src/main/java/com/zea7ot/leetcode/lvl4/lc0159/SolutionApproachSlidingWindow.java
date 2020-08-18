/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * 
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/49708/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.zea7ot.leetcode.lvl4.lc0159;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachSlidingWindow {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0, right = 0, counter = 0, len = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) == 1) counter++;
            right++;
            while(counter > 2){
                char temp = s.charAt(left);
                map.put(temp, map.get(temp) - 1);
                if(map.get(temp) == 0){
                    counter--;
                }
                
                left++;
            }
            
            len = Math.max(len, right - left);
        }
        
        return len;
    }
}