/**
 * https://leetcode.com/problems/longest-repeating-substring/
 * 
 * Time Complexity:     O((L ^ 2) * lg(L))
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/longest-repeating-substring/discuss/303884/easy-to-understand-N2-solution
 */
package com.zea7ot.lc.lvl4.lc1062;

import java.util.Arrays;

public class SolutionApproach2Sorting {
    public int longestRepeatingSubstring(String S) {
        // sanity check
        if(S == null || S.isEmpty()) return 0;

        final int L = S.length();
        String[] suffixes = new String[L];
        for(int i = 0; i < L; ++i)
            suffixes[i] = S.substring(i);
        
        Arrays.sort(suffixes);
        int longest = 0;
        for(int i = 1; i < L; ++i){
            String a = suffixes[i - 1], b = suffixes[i];
            int len = Math.min(a.length(), b.length());
            for(int j = 0; j < len; ++j){
                if(a.charAt(j) != b.charAt(j)) break;
                longest = Math.max(longest, j + 1);
            }
        }
        
        return longest;
    }
}