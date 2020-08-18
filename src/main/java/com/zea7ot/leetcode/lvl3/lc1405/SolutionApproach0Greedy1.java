/**
 * https://leetcode.com/problems/longest-happy-string/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/longest-happy-string/discuss/565831/Java-Detailed-Explanation-Greedy-PriorityQueue-Easy-Understand-%2B-Clear
 */
package com.zea7ot.leetcode.lvl3.lc1405;

import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach0Greedy1 {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder builder = new StringBuilder();
        Queue<Letter> maxHeap = new PriorityQueue<Letter>((x, y) -> Integer.compare(y.freq, x.freq));
        if(a > 0) maxHeap.add(new Letter('a', a));
        if(b > 0) maxHeap.add(new Letter('b', b));
        if(c > 0) maxHeap.add(new Letter('c', c));
        
        while(!maxHeap.isEmpty()){
            final int L = builder.length();
            Letter most = maxHeap.poll();
            char ch = most.letter;
            
            if(L < 2 || (builder.charAt(L - 2) != ch || builder.charAt(L - 1) != ch)){
                builder.append(ch);
                --most.freq;
            }else{
                Letter secondMost = maxHeap.poll();
                if(secondMost == null) continue;
                builder.append(secondMost.letter);
                --secondMost.freq;
                
                if(secondMost.freq > 0) 
                    maxHeap.add(secondMost);
            }
            
            if(most.freq > 0) maxHeap.add(most);
        }
        
        return builder.toString();
    }
    
    private class Letter{
        protected char letter;
        protected int freq;
        
        protected Letter(char letter, int freq){
            this.letter = letter;
            this.freq = freq;
        }
    }
}