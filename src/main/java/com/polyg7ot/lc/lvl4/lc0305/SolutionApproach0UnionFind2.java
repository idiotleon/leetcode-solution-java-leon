/**
 * https://leetcode.com/problems/number-of-islands-ii/
 * 
 * Time Complexity: O()
 * Space Complexity: O(m * n)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-islands-ii/discuss/75470/Easiest-Java-Solution-with-Explanations
 */
package com.polyg7ot.lc.lvl4.lc0305;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0UnionFind2 {
    private final static int[] DIRS = {0, -1, 0, 1, 0};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(m <= 0 || n <= 0 || positions == null) return ans;
        
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);

        int count = 0;
        for(int[] position : positions){
            int row = position[0], col = position[1];
            int root = n * row + col;
            // to prevent duplicates
            if(roots[root] != -1){
                ans.add(count);
                continue;
            }
            
            roots[root] = root;
            count++;
            
            for(int d = 0; d < 4; d++){
                int r = row + DIRS[d], c = col + DIRS[d + 1];
                int neighbor = n * r + c;
                if(r < 0 || r >= m || c < 0 || c >= n || roots[neighbor] == -1) continue;
                
                int rootNeighbor = findIsland(roots, neighbor);
                if(root != rootNeighbor){
                    roots[root] = rootNeighbor;
                    root = rootNeighbor;
                    count--;
                }
            }
            
            ans.add(count);
        }
        
        return ans;
    }
    
    // with path compression
    private int findIsland(int[] roots, int id){
        while(id != roots[id]){
            roots[id] = roots[roots[id]];
            id = roots[id];
        }

        return id;
    }
}