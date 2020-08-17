/**
 * https://leetcode.com/problems/possible-bipartition/
 * 
 * Time Complexity: O(V + E) ~ O(N + dislikes.length)
 * Space Complexity: O(V + E) ~ O(N + dislikes.length)
 * 
 * References:
 *  https://leetcode.com/problems/possible-bipartition/discuss/158957/Java-DFS-solution
 */
package com.zea7ot.leetcode.lvl3.lc0886;

public class SolutionApproach0DFS {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        for(int[] dislike : dislikes){
            graph[dislike[0] - 1][dislike[1] - 1] = 1;
            graph[dislike[1] - 1][dislike[0] - 1] = 1;
        }
        
        int[] group = new int[N];
        for(int i = 0; i < N; i++){
            if(group[i] == 0 && !dfs(graph, group, i, 1)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] group, int index, int g){
        group[index] = g;
        for(int i = 0; i < graph.length; i++){
            if(graph[index][i] == 1){
                if(group[i] == g) return false;
                
                if(group[i] == 0 && !dfs(graph, group, i, -g)){
                    return false;
                }
            }
        }
        
        return true;
    }
}