/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 *  O(N), consumed by the call stack, in the "worst" case, where all pointed are "connected"
 *  O(N), consumed by the visited(set[])
 * 
 * References:
 *  https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/discuss/197668/Count-the-Number-of-Islands-O(N)/285615
 */
package com.zea7ot.leetcode.lvl4.lc0947;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0DFS {
    public int removeStones(int[][] stones) {
        // sanity check
        if(stones == null || stones.length == 0) return 0;
        
        final int N = stones.length;
        
        int count = 0;
        Set<Integer> visited = new HashSet<Integer>();
        for(int i = 0; i < N; i++){
            if(visited.contains(i)) continue;
            count++;
            dfs(stones, visited, i);
        }
        
        return N - count;
    }
    
    private void dfs(int[][] stones, 
                     Set<Integer> visited, 
                     int index){
        visited.add(index);
        
        for(int i = 0; i < stones.length; i++){
            if(visited.contains(i)) continue;
            
            if(stones[i][0] == stones[index][0] 
               || stones[i][1] == stones[index][1]){
                dfs(stones, visited, i);
            }
        }
    }
}