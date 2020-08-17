/**
 * https://leetcode.com/problems/flower-planting-with-no-adjacent/
 * 
 * Time Complexity:     O(N + paths.length)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/flower-planting-with-no-adjacent/discuss/290858/JavaC%2B%2BPython-Greedily-Paint
 *  https://leetcode.com/problems/flower-planting-with-no-adjacent/discuss/327959/Lee's-Solution-with-Comments
 */
package com.zea7ot.leetcode.lvl3.lc1042;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Greedy {
    public int[] gardenNoAdj(int N, int[][] paths) {
        List<List<Integer>> graph = buildGraph(N, paths);
        
        int[] ans = new int[N];
        for(int i = 0; i < N; i++){
            int[] colors = new int[5];
            for(int neighbor : graph.get(i)){
                colors[ans[neighbor]] = 1; // to use this color
            }

            // to greedily select the color that has not been used
            for(int color = 4; color > 0; color--){
                if(colors[color] == 0){ 
                    ans[i] = color;
                }
            }
        }
        
        return ans;
    }
    
    private List<List<Integer>> buildGraph(int N, int[][] paths){
        List<List<Integer>> graph =new ArrayList<List<Integer>>(N);
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] path : paths){
            int u = path[0] - 1, v = path[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return graph;
    }
}