/**
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.polyg7ot.lc.lvl4.lc0076;

public class SolutionApproachTwoPtrs1 {
    public String minWindow(String s, String t) {
        // sanity check
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        
        // to build up the dictionary
        int[] freq = new int[128];
        for(int i = 0; i < t.length(); i++){
            ++freq[t.charAt(i)];
        }
        
        int left = 0, count = t.length();
        String ans = "";
        
        for(int right = 0; right < s.length(); right++){
            // freq[s.charAt(right)] > 0 means s.charAt(right) is in t
            if(freq[s.charAt(right)] > 0) count--;
            // this will put chars that are not in t negative
            freq[s.charAt(right)]--;
            // we have not found all letters yet
            if(count > 0) continue;
            
            // we have found all letters
            while(count == 0){
                if(ans.length() == 0 || (right - left + 1) < ans.length()){
                    ans = s.substring(left, right + 1);
                }

                // to reduce the length till count > 0.
                // this automatically include the rightmost ones necessary if duplicates exist
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)] > 0) count++;
                left++;
            }
        }
        
        return ans;
    }
}