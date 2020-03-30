/**
 * https://leetcode.com/problems/word-break/
 * 
 * https://leetcode.com/problems/word-break/discuss/43819/DFS-with-Path-Memorizing-Java-Solution
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
package main.java.lcidiot.lc0139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionApproachDFS {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> visited = new HashSet<Integer>();
        return dfs(s, 0, new HashSet<String>(wordDict), visited);
    }
    
    private boolean dfs(String str, 
                        int index, 
                        Set<String> wordSet, 
                        Set<Integer> visited){
        // the base case
        if(index == str.length()) return true;
        
        // to check memory
        if(visited.contains(index)) return false;
        
        // recursion
        for(int i = index + 1; i <= str.length(); i++){
            String sub = str.substring(index, i);
            if(wordSet.contains(sub) && dfs(str, i, wordSet, visited)) 
                return true;
        }
        
        visited.add(index);
        return false;
    }
}