/**
 * https://leetcode.com/problems/number-of-islands-ii/
 * 
 * Time Complexity: O()
 * Space Complexity: O(2 * m * n) ~ O(m * n)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-islands-ii/discuss/75470/Easiest-Java-Solution-with-Explanations
 */
package com.zea7ot.lc.lvl4.lc0305;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0UnionFind {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(m <= 0 || n  <= 0 || positions == null) return ans;
        
        int[] roots = new int[m * n];
        int[] rank = new int[m * n];
        Arrays.fill(roots, -1);

        int count = 0;
        for(int[] pos : positions){
            int row = pos[0], col = pos[1];
            int island = n * row + col;
            // to prevent duplicates
            if(roots[island] != -1){
                ans.add(count);
                continue;
            }
            roots[island] = island;
            ++rank[island];
            count++;
            
            for(int d = 0; d < 4; d++){
                int r = row + DIRS[d], c = col + DIRS[d + 1];
                int neighbor = n * r + c;
                if(r < 0 || r >= m || c < 0 || c >= n || roots[neighbor] == -1) continue;
                
                int neighborRoot = find(roots, neighbor);
                int islandRoot = find(roots, island);
                if(islandRoot != neighborRoot){
                    // union by rank(size)
                    if(rank[islandRoot] >= rank[neighborRoot]){
                        rank[islandRoot] += rank[neighborRoot];
                        roots[neighborRoot] = islandRoot;
                    }else{
                        rank[neighborRoot] += rank[islandRoot];
                        roots[islandRoot] = neighborRoot;
                    }
                    count--;
                }
            }
            ans.add(count);
        }
        
        return ans;
    }
    
    private int find(int[] roots, int id){
        if(roots[id] == id) return id;
        roots[id] = find(roots, roots[id]); // path compression
        return roots[id];
    }
}