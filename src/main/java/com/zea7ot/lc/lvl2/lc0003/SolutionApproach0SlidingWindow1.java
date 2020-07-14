/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl2.lc0003;

public class SolutionApproach0SlidingWindow1 {
    public int lengthOfLongestSubstring(String s) {
        // sanity check
        if(s == null || s.length() == 0) return 0;
        
        final int L = s.length();
        char[] chs = s.toCharArray();
        int[] freq = new int[128];
        int left = 0, right = 0, longest = 0;
        while(right < L){
            ++freq[chs[right]];
            while(freq[chs[right]] > 1){
                --freq[chs[left++]];
            }
            // please pay more attention to where "right++" should be placed
            right++;
            longest = Math.max(longest, right - left);
        }
        
        return longest;
    }
}