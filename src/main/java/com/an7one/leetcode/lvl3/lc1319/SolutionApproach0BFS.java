/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 * 
 * Time Complexity:     O(n + L)
 * 
 * Space Complexity:    O(n)
 * 
 * 
 * References:
 *  https://leetcode.com/problems/number-of-operations-to-make-network-connected/discuss/477660/Java-Count-number-of-connected-components-Clean-code
 */
package com.an7one.leetcode.lvl3.lc1319;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionApproach0BFS {
    public int makeConnected(int n, int[][] connections) {
        // sanity check
        if(connections.length < n - 1) return -1;
        
        List<List<Integer>> graph = buildGraph(n, connections);       
        int components = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) components += bfs(i, graph, visited);
        return components - 1;
    }
    
    private int bfs(int start, List<List<Integer>> graph, boolean[] visited){
        if(visited[start]) return 0;
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int next : graph.get(top)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return 1;
    }
    
    private List<List<Integer>> buildGraph(int n, int[][] connections){
        List<List<Integer>> graph = new ArrayList<List<Integer>>(n);
        for(int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
        for(int[] connection : connections){
            int u = connection[0], v = connection[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return graph;   
    }
}