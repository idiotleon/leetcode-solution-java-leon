/**
 * https://leetcode.com/problems/surrounded-regions/
 * 
 * very slim UnionFind class
 * very flexible UnionFind operations
 */
package com.null7ptr.lc.lvl3.lc0130;

public class SolutionApproachUnionFind {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int nr = 0, nc = 0;
    
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        nr = board.length;
        nc = board[0].length;
        
        UnionFind uf = new UnionFind(nr * nc + 1);
        int dummyNode = nr * nc;
        
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                if(board[row][col] == 'O'){
                    if(row == 0 || row == nr - 1 || col == 0 || col == nc - 1) {
                        uf.union(node(row, col), dummyNode);
                    } 
                    else {
                        for(int[] dir : DIRS){
                            int r = row + dir[0], c = col + dir[1];
                            if(r >= 0 && r < nr && c >= 0 && c < nc && board[r][c] == 'O') {
                                uf.union(node(row, col), node(r, c));
                            }
                        }
                    }
                }
            }
        }

        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                if(uf.isConnected(node(row, col), dummyNode)) {
                    board[row][col] = 'O';
                } 
                else {
                    board[row][col] = 'X';
                }
            }
        }
    }
    
    private int node(int row, int col){
        return row * nc + col;
    }
    
    class UnionFind{
        int[] parents;
        
        public UnionFind(int totalNumber){
            parents = new int[totalNumber];
            // such an initialization is important, 
            // without which, 
            // parents of 'X's might be collided with ones of 'O's on the border
            for(int i = 0; i < totalNumber; i++){
                parents[i] = i;                  
            }  
        }
        
        public void union(int x, int y){
            int rootx = find(x), rooty = find(y);
            
            if(rootx != rooty){
                parents[rooty] = rootx;
            }
        }
        
        public int find(int i){
            if(parents[i] != i) {
                parents[i] = find(parents[i]);
            }
            return parents[i];
        }
        
        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
}