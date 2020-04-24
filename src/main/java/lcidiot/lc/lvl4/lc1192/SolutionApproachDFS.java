/**
 * https://leetcode.com/problems/critical-connections-in-a-network/
 */
package main.java.lcidiot.lc.lvl4.lc1192;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDFS {
    private boolean[] visited;
    private int[] ids;
    private int id;
    private int[] low;
    private List<List<Integer>> ans;
    private List<Integer>[] graph;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // sanity check
        ans = new ArrayList<List<Integer>>();
        if(n <= 0) return ans;
        
        // prepartion work
        visited = new boolean[n];
        ids = new int[n];
        id = 0;
        low = new int[n];
        
        // to build up the graph
        graph = new List[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(List<Integer> conn : connections){
            graph[conn.get(0)].add(conn.get(1));
            graph[conn.get(1)].add(conn.get(0));
        }
        
        // core logic
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, -1);
            }
        }
        
        return ans;
    }
    
    private void dfs(int at, int parent){
        visited[at] = true;
        ids[at] = ++id;
        low[at] = ids[at];
        
        for(int to : graph[at]){
            if(to == parent) continue;
            
            if(!visited[to]){
                dfs(to, at);
                low[at] = Math.min(low[at], low[to]);
                if(ids[at] < low[to]){
                    ans.add(Arrays.asList(at, to));
                }
            }else{
                low[at] = Math.min(low[at], ids[to]);
            }
        }
    }
}