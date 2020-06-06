/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.lc.lvl5.lc0340;

public class SolutionApproachSlidingWindow {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {     
        int[] count = new int[256];
        int num = 0, ans = 0;
        for(int i = 0, j = 0; j < s.length(); j++){
            if(count[s.charAt(j)]++ == 0) num++;
            while(num > k && i < s.length()){
                count[s.charAt(i)]--;
                if(count[s.charAt(i)] == 0) num--;
                i++;
            }
            
            ans = Math.max(ans, j - i + 1);
        }
        
        return ans;
    }
}