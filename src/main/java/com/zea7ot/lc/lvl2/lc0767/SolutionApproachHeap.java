/**
 * https://leetcode.com/problems/reorganize-string/
 */
package com.zea7ot.lc.lvl2.lc0767;

import java.util.PriorityQueue;

public class SolutionApproachHeap {
    public String reorganizeString(String S) {
        // sanity check
        if(S == null || S.isEmpty()) return "";
        
        final int L = S.length();
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        
        int[] freq = new int[26];
        for(int i = 0; i < L; i++){
            // to check whether it is possible to reorganize the string,
            // while building up the frequency map
            if(++freq[S.charAt(i) - 'a'] > (L + 1) / 2) 
                return "";
        }
        
        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                heap.offer(new int[]{i, freq[i]});
            }
        }
        
        int[] prev = new int[]{-1, 0};
        StringBuilder builder = new StringBuilder();
        while(!heap.isEmpty()){
            // to get the most frequent letter
            int[] cur = heap.poll();
            
            // to add the previous letter back to PQ,
            // in order not to interfere against the "cur" poll
            if(prev[1] > 0) heap.offer(prev);
            
            // to construct the string
            builder.append((char)(cur[0] + 'a'));
            
            // to decrease the frequency of "cur" letter by 1
            --cur[1];
           
            // to set "cur" letter as the "prev" one
            prev = cur;
        }
        
        return builder.toString();
    }
}