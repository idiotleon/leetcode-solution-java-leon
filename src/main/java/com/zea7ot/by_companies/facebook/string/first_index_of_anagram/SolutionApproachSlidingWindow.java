/**
 * Given a source string and a target string, find the start index of the first anagram of the target string. 
 * string A is the anagram of string B means A has the same letter distribution with B, f
 * or example: "cat" has the following anagram: "cat", "cta", "act", "atc", "tca", "tac"
 * 
 * For example:
 * source: "banana", target: "na" -> return 1
 * source: "important", target: "ant" -> return 5
 * source: "verygood", target:"god" -> return -1. Even though "g", "o", "d" exists in "verygood"
 */
package com.zea7ot.algorithm.companies.facebook.string.first_index_of_anagram;

public class SolutionApproachSlidingWindow {
    public int firstIndexOfAnagram(String str, String pt){
        if(str == null || str.isEmpty() || pt == null || pt.isEmpty()) return -1;

        int[] freq = new int[26];
        for(int i = 0; i < pt.length(); i++){
            ++freq[pt.charAt(i) - 'a'];
        }

        int left = 0, right = 0, count = pt.length();
        while(right < str.length()){
            if(--freq[str.charAt(right++) - 'a'] >= 0) count--;

            if(right > left + pt.length()){
                if(++freq[str.charAt(left++) - 'a'] > 0) count++;
            }

            if(count == 0) return right - pt.length();
        }

        return -1;
    }
}