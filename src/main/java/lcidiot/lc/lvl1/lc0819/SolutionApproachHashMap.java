/**
 * https://leetcode.com/problems/most-common-word/
 */
package main.java.lcidiot.lc.lvl1.lc0819;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproachHashMap {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<String>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<String, Integer>();
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        
        for(String word : words){
            if(!ban.contains(word)){
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }
        
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}