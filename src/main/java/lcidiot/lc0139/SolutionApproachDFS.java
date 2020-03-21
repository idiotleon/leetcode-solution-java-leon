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
    public boolean wordBreak(String str, List<String> wordDict) {
        Set<Integer> set = new HashSet<Integer>();
        return dfs(str, 0, new HashSet<String>(wordDict), set);
    }
    
    private boolean dfs(String str, 
                        int index, 
                        Set<String> wordDict, 
                        Set<Integer> set){
        // base case
        if(index == str.length()) return true;
        
        // to check memory
        if(set.contains(index)) return false;
        
        // recursion
        for(int i = index + 1; i <= str.length(); i++){
            String sub = str.substring(index, i);
            if(wordDict.contains(sub) && dfs(str, i, wordDict, set)) 
                return true;
        }
        
        set.add(index);
        return false;
    }
}