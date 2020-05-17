/**
 * https://leetcode.com/problems/top-k-frequent-words/
 * 
 * Time Complexity: O(N * lg(k))
 * Space Complexity: O(k)
 */
package com.polyg7ot.lc.lvl2.lc0692;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach0Heap {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<String>();
        if(words == null || words.length == 0) return ans;
        
        Map<String, Integer> frequency = new HashMap<String, Integer>();
        for(String word : words){
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        
        // a minHeap is needed, instead of a maxHeap, to keep large elements in the bottom
        PriorityQueue<String> heap = new PriorityQueue<String>((str1, str2) -> frequency.get(str1) == frequency.get(str2) ? str2.compareTo(str1) : frequency.get(str1) - frequency.get(str2));
        
        for(String str : frequency.keySet()){
            heap.add(str);
            
            if(heap.size() > k){
                // to poll above elements
                heap.poll();
            }
        }
        
        while(!heap.isEmpty()){
            // do not forget to reverse the list, 
            // otherwise the Top k elements are sorted from low frequency to high frequency
            ans.add(0, heap.poll());
        }
        
        return ans;
    }
}