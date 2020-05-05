/**
 * https://leetcode.com/problems/is-graph-bipartite/
 */
package com.polyg7ot.lc.lvl3.lc0785;

public class SolutionApproachDFS {
    public boolean isBipartite(int[][] graph) {
        final int N = graph.length;
        int[] colors = new int[N];
        
        for(int i = 0; i < N; i++){
            if(colors[i] == 0 // to check each node that is not visited, this graph might be disconnected
               && !isValidColor(graph, colors, 1, i)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidColor(int[][] graph, 
                                 int[] colors, 
                                 int color, 
                                 int curNodeIdx){
        if(colors[curNodeIdx] != 0){
            return colors[curNodeIdx] == color;
        }
        
        colors[curNodeIdx] = color;
        for(int nextNodeIdx : graph[curNodeIdx]){
            if(!isValidColor(graph, colors, -color, nextNodeIdx)){
                return false;
            }
        }
        
        return true;
    }
}