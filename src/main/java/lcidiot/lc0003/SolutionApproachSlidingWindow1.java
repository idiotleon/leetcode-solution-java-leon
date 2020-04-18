/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Time Complexit: O(N)
 * Space Complexity: O(1)
 */
package main.java.lcidiot.lc0003;

public class SolutionApproachSlidingWindow1 {
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