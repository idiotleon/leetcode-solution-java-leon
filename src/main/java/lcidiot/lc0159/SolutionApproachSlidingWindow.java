/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * 
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/49708/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
 */
package main.java.lcidiot.lc0159;

import java.util.HashMap;
import java.util.Map;

class SolutionApproachSlidingWindow {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0, end = 0, counter = 0, len = 0;
        
        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) == 1) counter++;  // the new char
            end++;
            while(counter > 2){
                char tempChar = s.charAt(start);
                map.put(tempChar, map.get(tempChar) - 1);
                if(map.get(tempChar) == 0) counter--;
                start++;
            }
            
            len = Math.max(len, end - start);
        }
        
        return len;
    }
}