/**
 * https://leetcode.com/problems/number-of-islands/
 */
package main.java.lcidiot.lc0200;

class SolutionApproachDFS {
    private int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int nr = 0, nc = 0;
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        nr = grid.length;
        nc = grid[0].length;
        int numIslands = 0;
        
        for(int row = 0; row < nr; row++)
            for(int col = 0; col < nc; col++)
                if(grid[row][col] == '1'){
                    ++numIslands;
                    dfs(grid, row, col);
                }
        
        return numIslands;
    }
    
    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= nr || col >= nc || grid[row][col] == '0') return;
        
        grid[row][col] = '0';
        for(int[] dir : DIRS){
            int r = row + dir[0], c = col + dir[1];
            dfs(grid, r, c);
        }
    }
}