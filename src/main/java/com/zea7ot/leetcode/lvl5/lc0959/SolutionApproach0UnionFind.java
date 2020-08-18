/**
 * https://leetcode.com/problems/regions-cut-by-slashes/
 * 
 * Time Complexity:     O((N - 1) ^ 2) ~ O(N ^ 2)
 * Space Complexity:    O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/regions-cut-by-slashes/discuss/233278/Java-better-solution-with-Union-Find-100-(time)
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/number-of-islands/
 *  https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */
package com.zea7ot.leetcode.lvl5.lc0959;

public class SolutionApproach0UnionFind {
    public int regionsBySlashes(String[] grid) {
        final int N = grid.length;
        int count = 1;
        
        UnionFind uf = new UnionFind(N + 1);
        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                count += uf.union(row, col, grid[row].charAt(col));
            }
        }
        
        return count;
    }
    
    private class UnionFind{
        private int width;
        private int[] roots;
        private int[] weight;
        
        protected UnionFind(final int N){
            this.width = N;
            final int SIZE = N * N;
            roots = new int[SIZE];
            weight = new int[SIZE];
            
            for(int i = 0; i < SIZE; i++){
                roots[i] = i;
            }
            
            int gap = SIZE - N;
            for(int i = 0; i < N; i++){
                roots[i] = 0;
                roots[i + gap] = 0;
            }
            
            gap = N - 1;
            for(int i = 0; i < SIZE; i += N){
                roots[i] = 0;
                roots[i + gap] = 0;
            }
            
            weight[0] = N * 4 - 4;
            for(int i = 1; i < SIZE; i++){
                weight[i] = 1;
            }
        }
        
        private int find(int x){
            while(x != roots[x]){
                roots[x] = roots[roots[x]];
                x = roots[x];
            }
            
            return x;
        }
        
        private int union(int row, int col, char op){
            if(op == ' ') return 0;
            int root1, root2;
            if(op == '/'){
                root1 = find(index(row, col) + 1);
                root2 = find(index(row + 1, col));
            }else{
                root1 = find(index(row, col));
                root2 = find(index(row + 1, col + 1));
            }
            
            if(root1 == root2) return 1;
            if(weight[root1] < weight[root2]){
                roots[root1] = root2;
                weight[root2] += weight[root1];
            }else{
                roots[root2] = root1;
                weight[root1] += weight[root2];
            }
            
            return 0;
        }
        
        private int index(int row, int col){
            return row * width + col;
        }
    }
}