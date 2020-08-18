/**
 * https://leetcode.com/problems/surrounded-regions/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * very slim UnionFind class
 * very flexible UnionFind operations
 */
package com.zea7ot.leetcode.lvl3.lc0130;

public class SolutionApproach0UnionFind {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int NR, NC;
    
    public void solve(char[][] board) {
        // sanity check
        if(board == null || board.length == 0 || board[0].length == 0) return;

        this.NR = board.length;
        this.NC = board[0].length;
        
        UnionFind uf = new UnionFind(NR * NC + 1);
        int dummyNode = NR * NC;
        
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(board[row][col] != 'O') continue;
                if(row == 0 || row == NR - 1 || col == 0 || col == NC - 1)
                    uf.union(index(row, col), dummyNode);
                else for(int[] dir : DIRS){
                        int r = row + dir[0], c = col + dir[1];
                        if(r < 0 || r >= NR || c < 0 && c >= NC || board[r][c] != 'O') continue;
                        uf.union(index(row, col), index(r, c));
                    }
            }
        }

        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(uf.isConnected(index(row, col), dummyNode))
                    board[row][col] = 'O';
                else board[row][col] = 'X';
            }
        }
    }
    
    private int index(int row, int col){
        return row * NC + col;
    }
    
    private class UnionFind{
        private int[] parents;
        
        protected UnionFind(int totalNumber){
            parents = new int[totalNumber];
            // such an initialization is important, 
            // without which, 
            // parents of 'X's might be collided with ones of 'O's on the border
            for(int i = 0; i < totalNumber; i++){
                parents[i] = i;                  
            }  
        }
        
        protected void union(int x, int y){
            int rootx = find(x), rooty = find(y);
            
            if(rootx != rooty){
                parents[rooty] = rootx;
            }
        }
        
        protected int find(int i){
            if(parents[i] != i) {
                parents[i] = find(parents[i]);
            }
            return parents[i];
        }
        
        protected boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
}