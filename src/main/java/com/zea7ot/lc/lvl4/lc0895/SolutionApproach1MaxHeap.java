/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 * 
 * Time Complexities:
 *  `push(int x)`:      O(lg(N))
 *  `pop()`:            O(1)
 * 
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-frequency-stack/discuss/163416/Java-Priority-Queue-easy-understand
 */
package com.zea7ot.lc.lvl4.lc0895;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach1MaxHeap {
    private PriorityQueue<Node> maxHeap;
    private Map<Integer, Integer> freqMap;
    private int timestamp;

    public SolutionApproach1MaxHeap() {
        this.maxHeap = new PriorityQueue<Node>();
        this.freqMap = new HashMap<Integer, Integer>();
        this.timestamp = 0;
    }
    
    public void push(int x) {
        freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        Node node = new Node(x, freqMap.get(x), ++timestamp);
        maxHeap.offer(node);
    }
    
    public int pop() {
        Node node = maxHeap.poll();
        int value = node.value;
        freqMap.put(value, freqMap.getOrDefault(value, 0) - 1);
        if(freqMap.get(value) == 0) freqMap.remove(value);
        return node.value;
    }
    
    private class Node implements Comparable<Node>{
        protected int value;
        protected int freq;
        protected int timestamp;
        protected Node(int value, int freq, int timestamp){
            this.value = value;
            this.freq = freq;
            this.timestamp = timestamp;
        }
        
        @Override
        public int compareTo(Node that){
            if(this.freq != that.freq) return Integer.compare(that.freq, this.freq);
            
            return Integer.compare(that.timestamp, this.timestamp);
        }
    }
}