/**
 * https://leetcode.com/problems/top-k-frequent-words/
 * 
 * Time Complexity:     O(N * lg(k))
 * Space Complexity:    O(k)
 */
package com.zea7ot.lc.lvl2.lc0692;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach0MinHeap {
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> ans = new LinkedList<String>();
        // sanity check
        if(words == null || words.length == 0) return ans;
        
        Map<String, Integer> freqMap = new HashMap<String, Integer>();
        for(String word : words){
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        
        // a minHeap is needed, instead of a maxHeap, to keep large elements in the bottom
        PriorityQueue<String> minHeap = new PriorityQueue<String>((str1, str2) 
            -> freqMap.get(str1) == freqMap.get(str2) ? str2.compareTo(str1) : Integer.compare(freqMap.get(str1), freqMap.get(str2)));
        
        for(String str : freqMap.keySet()){
            minHeap.add(str);
            if(minHeap.size() > k) minHeap.poll();
        }
        
        while(!minHeap.isEmpty()){
            // do not forget to reverse the list, 
            // otherwise the Top k elements are sorted from low frequency to high frequency
            ans.addFirst(minHeap.poll());
        }
        
        return ans;
    }
}