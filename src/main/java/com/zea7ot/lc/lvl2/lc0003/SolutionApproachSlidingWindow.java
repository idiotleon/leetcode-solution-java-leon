
/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl2.lc0003;

public class SolutionApproachSlidingWindow {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        
        int[] index = new int[128];
        for(int j = 0, i = 0; j < s.length(); j++){
            i = Math.max(i, index[s.charAt(j)]);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        
        return ans;
    }
}