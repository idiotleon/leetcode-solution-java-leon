/**
 * https://leetcode.com/problems/is-graph-bipartite/
 */
package main.java.lcidiot.lc.lvl3.lc0785;

public class SolutionApproachUnionFind {
    public boolean isBipartite(int[][] graph) {
        UnionFind uf = new UnionFind(graph.length);
        
        for(int cur = 0; cur < graph.length; cur++){
            int[] adjacencies = graph[cur];
            for(int j = 0; j < adjacencies.length; j++){
                if(uf.find(cur) == uf.find(adjacencies[j])) return false;
                uf.union(adjacencies[0], adjacencies[j]);
            }
        }
        
        return true;
    }
    
    class UnionFind{
        int[] parent;
        
        public UnionFind(int len){
            parent = new int[len];
            for(int i = 0; i < len; i++){
                parent[i] = i;
            }
        }
        
        public void union(int i, int j){
            int rooti = find(i), rootj = find(j);
            if(rooti != rootj){
                parent[rooti] = rootj;
            }
        }
        
        public int find(int i){
            if(parent[i] != i){
                return find(parent[i]);
            }
            
            return parent[i];
        }
    }
}