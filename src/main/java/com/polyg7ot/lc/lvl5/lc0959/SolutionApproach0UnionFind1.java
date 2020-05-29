/**
 * https://leetcode.com/problems/regions-cut-by-slashes/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/regions-cut-by-slashes/discuss/233278/Java-better-solution-with-Union-Find-100-(time)
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/number-of-islands/
 *  https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */
package com.polyg7ot.lc.lvl5.lc0959;

public class SolutionApproach0UnionFind1 {
    public int regionsBySlashes(String[] grid) {
        final int N = grid[0].length();
        int count = 1;
        
        UnionFind uf = new UnionFind(N + 1);
        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                char op = grid[row].charAt(col);
                if(op == '/'){
                    if(uf.isConnected(row, col + 1, row + 1, col)) ++count;
                    uf.union(row, col + 1, row + 1, col);
                }else if(op == '\\'){
                    if(uf.isConnected(row, col, row + 1, col + 1)) ++count;
                    uf.union(row, col, row + 1, col + 1);
                }
            }
        }
        
        return count;
    }
    
    private class UnionFind{
        private int width;
        private int size;
        private int[] roots;
        private int[] weight;
        
        protected UnionFind(final int N){
            width = N;
            size = N * N;
            roots = new int[size];
            weight = new int[size];
            
            for(int i = 0; i < size; i++){
                roots[i] = i;
            }
            
            int gap = size - N;
            for(int i = 0; i < N; i++){
                roots[i] = 0;
                roots[i + gap] = 0;
            }
            
            gap = N - 1;
            for(int i = 0; i < size; i += N){
                roots[i] = 0;
                roots[i + gap] = 0;
            }
            
            weight[0] = N * 4 - 4;
            for(int i = 1; i < size; i++){
                weight[i] = 1;
            }
        }
        
        private int index(int row, int col){
            return row * width + col;
        }
        
        private int find(int x){
            while(x != roots[x]){
                roots[x] = roots[roots[x]];
                x = roots[x];
            }
            
            return x;
        }
        
        private void union(int row1, int col1, int row2, int col2){
            int root1 = find(index(row1, col1)), root2 = find(index(row2, col2));
            
            if(root1 == root2) return;
            if(weight[root1] < weight[root2]){
                roots[root1] = root2;
                weight[root2] += weight[root1];
            }else{
                roots[root2] = root1;
                weight[root1] += weight[root2];
            }
        }
        
        private boolean isConnected(int row1, int col1, int row2, int col2){
            return find(index(row1, col1)) == find(index(row2, col2));
        }
    }
}