/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0003;

public class SolutionApproach0SlidingWindow2 {
    public int lengthOfLongestSubstring(String s) {
        // sanity check
        if(s == null || s.length() == 0) return 0;
        
        int[] freq = new int[128];
        int left = 0, right = 0, longest = 0;
        while(right < s.length()){
            ++freq[s.charAt(right)];
            while(freq[s.charAt(right)] > 1){
                --freq[s.charAt(left++)];
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        
        return longest;
    }
}