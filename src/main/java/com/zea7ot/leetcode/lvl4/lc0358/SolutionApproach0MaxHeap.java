/**
 * https://leetcode.com/problems/rearrange-string-k-distance-apart/
 * 
 * Time Complexity:     O(L * lg(26)) ~ O(L)
 * Space Complexity:    O(L)
 */
package com.zea7ot.leetcode.lvl4.lc0358;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach0MaxHeap {
    public String rearrangeString(String s, int k) {
        if(k == 0) return s;
        
        char[] chs = s.toCharArray();
        int[] freq = new int[26];
        for(char ch : chs){
            ++freq[ch - 'a'];
        }
        
        Queue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                maxHeap.add(new int[]{i, freq[i]});
            }
        }
        
        StringBuilder builder = new StringBuilder();
        Queue<int[]> waiting = new LinkedList<int[]>();
        while(!maxHeap.isEmpty()){
            int[] top = maxHeap.poll();
            builder.append((char)(top[0] + 'a'));
            --top[1];
            waiting.add(top);
            if(waiting.size() == k){
                int[] front = waiting.poll();
                if(front[1] > 0){
                    maxHeap.add(front);
                }
            }
        }
        
        return builder.length() == s.length() ? builder.toString() : "";
    }
}