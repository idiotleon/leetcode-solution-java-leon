/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * 
 * Time Complexity: O(L * lg(N))
 *  N, distinct characters
 * Space Complexity: O(26) ~ O(1)
 * 
 * Refereneces:
 *  https://leetcode.com/problems/sort-characters-by-frequency/discuss/93420/Java-O(n)-Bucket-Sort-Solution-O(nlogm)-PriorityQueue-Solution-easy-to-understand
 */
package com.idiotleon.leetcode.lvl2.lc0451;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionAppraoch0PriorityQueue {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) return "";
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for(char ch : s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        
        PriorityQueue<Character> heap = new PriorityQueue<Character>((a, b) -> freq.get(a) == freq.get(b) ? b - a : freq.get(b) - freq.get(a));
        heap.addAll(freq.keySet());
        
        StringBuilder builder = new StringBuilder();
        while(!heap.isEmpty()){
            char ch = heap.poll();
            for(int i = 0; i < freq.get(ch); i++){
                builder.append(ch);
            }
        }
        
        return builder.toString();
    }
}