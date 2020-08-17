/**
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * Reference:
 *  https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/discuss/553574/Java-DFS-Solution-Clean-code
 */
package com.zea7ot.leetcode.lvl3.lc1391;

public class SolutionApproach0DFS {
    final int[][][] DIRS = {
        {{0, -1}, {0, 1}},
        {{-1, 0}, {1, 0}},
        {{0, -1}, {1, 0}},
        {{0, 1}, {1, 0}},
        {{0, -1}, {-1, 0}},
        {{-1, 0}, {0, 1}}
    };
    
    public boolean hasValidPath(int[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0 || grid[0].length == 0) return false;

        final int NR = grid.length, NC = grid[0].length;
        boolean[][] visited = new boolean[NR][NC];
        return dfs(grid, 0, 0, visited);
    }
    
    private boolean dfs(int[][] grid, int row, int col, boolean[][] visited){
        final int NR = grid.length, NC = grid[0].length;
        if(row == NR - 1 && col == NC - 1) return true;
        visited[row][col] = true;
        for(final int[] DIR : DIRS[grid[row][col] - 1]){
            int r = row + DIR[0], c = col + DIR[1];
            if(r < 0 || r >= NR || c < 0 || c >= NC || visited[r][c]) continue;
            for(final int[] BACK : DIRS[grid[r][c] - 1]){
                if(r + BACK[0] == row && c + BACK[1] == col){
                    if(dfs(grid, r, c, visited)) return true;
                }
            }
        }
        
        return false;
    }
}