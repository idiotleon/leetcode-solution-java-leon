/**
 * https://leetcode.com/problems/most-common-word/
 * 
 * Time Complexity:     O(LEN(paragraph))
 * Space Complexity:    O(NUM_WORDS(paragraph) - NUM(banned))
 */
package com.zea7ot.lc.lvl1.lc0819;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0HashMap {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<String>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<String, Integer>();
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        
        for(String word : words){
            if(ban.contains(word)) continue;
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}