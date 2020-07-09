/**
 * https://leetcode.com/problems/word-break/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl4.lc0139;

import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SolutionApproach0BFS {
    public boolean wordBreak(String str, List<String> wordDict) {
        // sanity check
        if(str == null || str.isEmpty()) return false;
        
        Set<String> wordSet = new HashSet<String>(wordDict);
        Set<String> visited = new HashSet<String>();

        Queue<String> queue = new LinkedList<String>();
        queue.offer(str);        
        
        while(!queue.isEmpty()){
            String cur = queue.poll();
            final int L = cur.length();
            for(int i = 1; i <= L; i++){
                if(!wordSet.contains(cur.substring(0, i))) continue;
                if(i == L) return true;
                
                String sub = cur.substring(i);
                if(visited.contains(sub)) continue;
                queue.offer(sub);
                visited.add(sub);
            }
        }
        
        return false;
    }
}