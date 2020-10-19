/**
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost/
 *
 * Time Complexity:     O(`N_CONN` * lg(`N_CONN`)) + O((E + V) * lg(V)) ~ O(`N_CONN` * lg(`N_CONN`)) + O((`O(`N_CONN` * lg(`N_CONN` + `N`)) * lg(`N`))
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/connecting-cities-with-minimum-cost/discuss/344867/Java-Kruskal's-Minimum-Spanning-Tree-Algorithm-with-Union-Find/669058
 *  https://leetcode.com/problems/connecting-cities-with-minimum-cost/discuss/344867/Java-Kruskal's-Minimum-Spanning-Tree-Algorithm-with-Union-Find
 */
package com.zea7ot.leetcode.lvl4.lc1135;

import java.util.PriorityQueue;

public class SolutionApproach0PrimMST {
    public int minimumCost(int N, int[][] connections) {     
        // not used
        // final int N_CONN = connections.length;
        
        UnionFind uf = new UnionFind(N);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for(int[] conn: connections){
            minHeap.offer(conn);
        }
        
        int cost = 0;
        int edge = 0;
        
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int x = cur[0], rootX = uf.find(x);
            int y = cur[1], rootY = uf.find(y);
            
            if(rootX != rootY){
                cost += cur[2];
                uf.union(x, y);
                if(++edge == N - 1) return cost;
            }
        }
        
        return -1;
    }
    
    private class UnionFind{
        private final int[] ROOTS;
        private final int[] RANKS;
        
        private UnionFind(final int CITIES){
            // 1-indexed
            this.ROOTS = new int[CITIES + 1];
            // 1-indexed
            this.RANKS = new int[CITIES + 1];
            for(int i = 0; i <= CITIES; ++i){
                ROOTS[i] = i;
                RANKS[i] = 1;
            }
        }
        
        private int find(int x){
            if(x != ROOTS[x]){
                ROOTS[x] = find(ROOTS[x]);
            }
            
            return ROOTS[x];
        }
        
        private void union(int x, int y){
            int rootX = find(x), rootY = find(y);
            
            if(RANKS[rootX] > RANKS[rootY]){
                ROOTS[rootY] = rootX;
                ++RANKS[rootX];
            }else{
                ROOTS[rootX] = rootY;
                ++RANKS[rootY];
            }
        }
    }
}
