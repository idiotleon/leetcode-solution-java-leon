/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.null7ptr.lc.lvl2.lc0003;

public class SolutionApproachSlidingWindow1 {
    public int lengthOfLongestSubstring(String s) {
        // sanity check
        if(s == null || s.length() == 0) return 0;
        
        int[] freq = new int[128];
        int left = 0, right = 0, ans = 0;
        while(right < s.length()){
            ++freq[s.charAt(right)];
            while(freq[s.charAt(right)] > 1){
                --freq[s.charAt(left++)];
            }
            // please pay more attention to where "right++" should be placed
            right++;
            ans = Math.max(ans, right - left);
        }
        
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int[] freq = new int[128];
        int left = 0, right = 0, ans = 0;
        while(right < s.length()){
            ++freq[s.charAt(right)];
            while(freq[s.charAt(right)] > 1){
                --freq[s.charAt(left++)];
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        
        return ans;
    }
}