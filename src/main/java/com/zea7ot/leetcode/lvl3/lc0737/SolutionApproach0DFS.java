/**
 * https://leetcode.com/problems/sentence-similarity-ii/
 * 
 * Time Complexity: O(words1.length * (3 * pairs.size()))
 * 
 * Space Complexity: O(3 * pairs.size()), in the worst case ~ O(pairs.size())
 * 
 * References:
 *  https://leetcode.com/problems/sentence-similarity-ii/discuss/109747/Java-Easy-DFS-solution-with-Explanation
 */
package com.zea7ot.leetcode.lvl3.lc0737;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0DFS {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length) return false;
        
        // to build up the graph
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        for(List<String> pair : pairs){
            String str1 = pair.get(0), str2 = pair.get(1);
            graph.putIfAbsent(str1, new ArrayList<String>());
            graph.putIfAbsent(str2, new ArrayList<String>());
            graph.get(str1).add(str2);
            graph.get(str2).add(str1);
        }
        
        for(int i = 0; i < words1.length; i++){
            if(words1[i].equals(words2[i])) continue;
            // where words1[i] is completely isolated among all pairs
            if(!graph.containsKey(words1[i])) return false;
            if(!dfs(graph, new HashSet<String>(), words1[i], words2[i])){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(Map<String, List<String>> graph, Set<String> visited, String start, String end){
        if(graph.get(start).contains(end)) return true;
        
        if(visited.add(start)){
            for(String next : graph.get(start)){
                if(!visited.contains(next) && dfs(graph, visited, next, end)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}