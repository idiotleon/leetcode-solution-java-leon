/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package main.java.lcidiot.lc.lvl3.lc0438;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachSlidingWindow1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();
        
        int[] freq = new int[26];
        for(int i = 0; i < p.length() ; i++){
            ++freq[p.charAt(i) - 'a'];
        }
        
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(i >= p.length()){
                ++freq[s.charAt(i - p.length()) - 'a'];
                if(freq[s.charAt(i - p.length()) - 'a'] > 0){
                    count--;
                }
            }
            
            freq[s.charAt(i) - 'a']--;
            
            if(freq[s.charAt(i) - 'a'] >= 0) count++;
            if(count == p.length()){
                ans.add(i - count + 1);
            }
        }
        
        return ans;
    }
}