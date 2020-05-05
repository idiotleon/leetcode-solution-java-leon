/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.polyg7ot.lc.lvl3.lc0438;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachSlidingWindow {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0) return ans;
        
        int[] hash = new int[256];
        for(int i = 0; i < p.length(); i++){
            ++hash[p.charAt(i)];
        }
        
        int left = 0, right = 0, count = p.length();
        while(right < s.length()){
            if(hash[s.charAt(right++)]-- > 0) count--;
            
            if(count == 0) ans.add(left);
            
            if(right - left == p.length() && hash[s.charAt(left++)] ++ >= 0) count++;
        }
        
        return ans;
    }
}