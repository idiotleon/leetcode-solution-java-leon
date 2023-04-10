/**
 * https://leetcode.com/problems/maximum-freqMapuency-stack/
 * 
 * Time Complexities:
 *  `push(int x)`:  O(1)
 *  `pop()`:        O(1)
 * 
 * Space Complexities: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-frequency-stack/discuss/163410/C%2B%2BJavaPython-O(1)
 */
package com.idiotleon.leetcode.lvl4.lc0895;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SolutionApproach0HashMaps {
    private Map<Integer, Integer> freqMap;
    private Map<Integer, Stack<Integer>> map;
    private int maxFreq;

    public SolutionApproach0HashMaps() {
        this.freqMap = new HashMap<Integer, Integer>();
        this.map = new HashMap<Integer, Stack<Integer>>();
        this.maxFreq = 0;
    }
    
    public void push(int x) {
        int freq = freqMap.getOrDefault(x, 0) + 1;
        freqMap.put(x, freq);
        maxFreq = Math.max(maxFreq, freq);
        map.putIfAbsent(freq, new Stack<Integer>());
        map.get(freq).add(x);
    }
    
    public int pop() {
        int x = map.get(maxFreq).pop();
        freqMap.put(x, maxFreq - 1);
        if(map.get(maxFreq).size() == 0) maxFreq--;
        return x;
    }
}