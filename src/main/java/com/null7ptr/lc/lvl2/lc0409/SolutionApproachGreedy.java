/**
 * https://leetcode.com/problems/longest-palindrome/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.null7ptr.lc.lvl2.lc0409;

public class SolutionApproachGreedy {
    public int longestPalindrome(String str) {
        if(str == null || str.length() == 0) return 0;
        
        int[] counts = new int[128];
        int ans = 0;
        for(int i = 0; i < str.length(); i++){
            ++counts[str.charAt(i)];
        }
        
        int odd = 0;
        for(int count : counts){
            ans += count % 2 == 0 ? count : count - 1;
            
            if(count % 2 == 1){
                odd = 1;
            }
        }
        
        ans += odd;
        
        return ans;
    }
}