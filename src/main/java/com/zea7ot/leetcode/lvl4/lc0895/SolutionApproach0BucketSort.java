/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 * 
 * Time Complexities:
 *  `push(int x)`:      O(1)
 */
package com.zea7ot.leetcode.lvl4.lc0895;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SolutionApproach0BucketSort {
    private List<Stack<Integer>> bucket;
    private Map<Integer, Integer> freqMap;

    public SolutionApproach0BucketSort() {
        this.bucket = new ArrayList<Stack<Integer>>();
        this.freqMap = new HashMap<Integer, Integer>();
    }
    
    public void push(int x) {
        freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        int freq = freqMap.get(x);
        if(freq - 1 >= bucket.size()){
            bucket.add(new Stack<Integer>());
        }
        bucket.get(freq - 1).add(x);
    }
    
    public int pop() {
        int freq = bucket.size();
        int x = bucket.get(freq - 1).pop();
        if(bucket.get(freq - 1).isEmpty()){
            bucket.remove(bucket.size() - 1);
        }
        
        freqMap.put(x, freqMap.get(x) - 1);
        if(freqMap.get(x) == 0) freqMap.remove(x);
        
        return x;
    }
}