
/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0003;

public class SolutionApproach0SlidingWindow {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        
        final int L = s.length();
        char[] chs = s.toCharArray();
        int[] index = new int[128];
        for(int j = 0, i = 0; j < L; j++){
            i = Math.max(i, index[chs[j]]);
            longest = Math.max(longest, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        
        return longest;
    }
}