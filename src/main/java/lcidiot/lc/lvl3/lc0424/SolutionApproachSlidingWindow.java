/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
package main.java.lcidiot.lc.lvl3.lc0424;

public class SolutionApproachSlidingWindow {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int ans = 0, maxCount = 0;
        int left = 0, right = 0;
        
        while(right < s.length()){
            ++freq[s.charAt(right) - 'A'];
            // only need to track the max count of characters
            maxCount = Math.max(maxCount, freq[s.charAt(right) -'A']);
            right++;
            // to track the length if valid
            if(maxCount + k >= right - left){
                ans = Math.max(maxCount, right - left);
            }else{
                // to shrink the window by one when invalid
                --freq[s.charAt(left) - 'A'];
                left++;
            }
        }
        
        return ans;
    }
}