/**
 * https://leetcode.com/problems/number-of-islands/
 */
package main.java.lcidiot.lc0200;

class Solution {
    private final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int nr = grid.length, nc = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for(int row = 0; row < nr; row++)
            for(int col = 0; col < nc; col++)
                if(grid[row][col] == '1'){
                    grid[row][col] = '0';
                    
                    for(int[] dir : DIRS){
                        int r = row + dir[0], c = col + dir[1];
                        if(r >= 0 && c >= 0 && r < nr && c < nc && grid[r][c] == '1') 
                            uf.union(row * nc + col, r * nc + c);
                    }
                }
        
        return uf.getCount();
    }
    
    class UnionFind{
        int count;
        int[] parent, rank;
        
        public UnionFind(char[][] grid){
            int nr = grid.length, nc = grid[0].length;
            parent = new int[nr * nc];
            rank = new int[nr * nc];
            
            for(int row = 0; row < nr; row++)
                for(int col = 0; col < nc; col++){
                    if(grid[row][col] == '1'){
                        parent[row * nc + col] = row * nc + col;
                        ++count;
                    }
                    
                    rank[row * nc + col] = 0;
                }
        }
        
        public void union(int x, int y){
            int rootx = find(x), rooty = find(y);
            
            if(rootx != rooty){
                if(rank[rootx] > rank[rooty])
                    parent[rooty] = rootx;
                else if(rank[rootx] < rank[rooty])
                    parent[rootx] = rooty;
                else{
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                
                --count;
            }
        }
        
        public int find(int i){
            if(parent[i] != i) 
                parent[i] = find(parent[i]);
            return parent[i];
        }
        
        public int getCount(){
            return count;
        }
    }
}