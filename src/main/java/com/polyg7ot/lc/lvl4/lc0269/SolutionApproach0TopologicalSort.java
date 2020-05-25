/**
 * https://leetcode.com/problems/alien-dictionary/
 * 
 * Time Complexity: O(V + E) ~ O(26 + N * L)
 * Space Complexity: O(V + E) ~ O(26 + N * L)
 */
package com.polyg7ot.lc.lvl4.lc0269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SolutionApproach0TopologicalSort {
    public String alienOrder(String[] words) {
        StringBuilder builder = new StringBuilder();
        List<Set<Integer>> nextSets = new ArrayList<Set<Integer>>();
        for(int i = 0; i < 26; i++){
            nextSets.add(new HashSet<Integer>());
        }
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        
        final int L = words.length;
        
        // to build up the graph
        for(int i = 0; i < L; i++){
            // to initialize letters/chars that have appeared only
            for(char ch : words[i].toCharArray()){
                if(indegree[ch - 'a'] == -1){
                    indegree[ch - 'a'] = 0;
                }
            }
            
            if(i > 0){
                String prevWord = words[i - 1], curWord = words[i];
                final int PREV_L = prevWord.length(), CUR_L = curWord.length(), LEN = Math.max(PREV_L, CUR_L);
                for(int j = 0; j < LEN; j++){
                    if(j == PREV_L) break;
                    else if(j == CUR_L) return "";
                    else{
                        if(prevWord.charAt(j) != curWord.charAt(j)){
                            int prevIdx = prevWord.charAt(j) - 'a';
                            int curIdx = curWord.charAt(j) - 'a';
                            
                            if(!nextSets.get(prevIdx).contains(curIdx)){
                                nextSets.get(prevIdx).add(curIdx);
                                ++indegree[curIdx];
                            }
                            
                            // one any difference of the two chars is hit, 
                            // no need to compare the rest
                            break;
                        }
                    }
                }
            }
        }
        
        // to topological sort
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int idx = queue.removeFirst();
            
            for(int next : nextSets.get(idx)){
                if(--indegree[next] == 0){
                    queue.add(next);
                };
            }

            builder.append((char)(idx + 'a'));
        }
        
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] > 0){
                return "";
            }
        }
        
        return builder.toString();
    }
}