/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * 
 * Time Complexity: O(N * lg(N))
 * Space Complexity: O(N)
 */
package com.an7one.leetcode.lvl2.lc0451;

import java.util.Arrays;

public class SolutionApproach0Sorting {
    public String frequencySort(String s) {
        Character[] chs = s.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        
        int[] freq = new int[128];
        for(char ch : chs){
            ++freq[ch];
        }
        
        Arrays.sort(chs, (a, b) -> freq[b] == freq[a] ? b - a : Integer.compare(freq[b], freq[a]));
        
        StringBuilder builder = new StringBuilder();
        for(Character ch : chs){
            builder.append(ch);
        }
        
        return builder.toString();
    }
}