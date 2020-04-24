/**
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package main.java.lcidiot.lc.lvl4.lc0076;

public class SolutionApproachTwoPointers {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        
        int[] freq = new int[128];
        for(int i = 0; i < t.length(); i++){
            ++freq[t.charAt(i)];
        }
        
        int left = 0, count = t.length();
        String ans = "";
        
        for(int right = 0; right < s.length(); right++){
            if(freq[s.charAt(right)] > 0) count--;
            --freq[s.charAt(right)];
            if(count > 0) continue;
            
            while(count == 0){
                if(ans.isEmpty() || (right - left + 1) < ans.length()){
                    ans = s.substring(left, right + 1);
                }
                ++freq[s.charAt(left)];
                if(freq[s.charAt(left)] > 0) count++;
                left++;
            }
        }
        
        return ans;
    }
}