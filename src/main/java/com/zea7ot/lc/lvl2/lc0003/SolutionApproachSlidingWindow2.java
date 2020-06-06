/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl2.lc0003;

public class SolutionApproachSlidingWindow2 {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int left = 0, right = 0, len = 0, threshold = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            ++freq[c];
            if(freq[c] > 1) threshold++;
            right++;
            
            while(threshold > 0){
                char temp = s.charAt(left);
                if(freq[temp] > 1){
                    threshold--;
                }
                --freq[temp];
                left++;
            }
            
            len = Math.max(len, right - left);
        }
        
        return len;
    }
}