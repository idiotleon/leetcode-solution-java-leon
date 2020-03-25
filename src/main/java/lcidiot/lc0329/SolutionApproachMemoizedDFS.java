/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
package main.java.lcidiot.lc0329;

class SolutionApproachMemoizedDFS {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int nr, nc;
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        nr = matrix.length;
        nc = matrix[0].length;
        
        int[][] cache = new int[nr][nc];
        int ans = 0;
        for(int row = 0; row < nr; row++)
            for(int col = 0; col < nc; col++)
                ans = Math.max(ans, dfs(matrix, row, col, cache));
        
        return ans;
    }
    
    private int dfs(int[][] matrix, int row, int col, int[][] cache){
        if(cache[row][col] != 0) return cache[row][col];
        
        for(int[] dir : DIRS){
            int r = row + dir[0], c = col + dir[1];
            if(r >= 0 && r < nr && c >= 0 && c < nc && matrix[r][c] > matrix[row][col])
                cache[row][col] = Math.max(cache[row][col], dfs(matrix, r, c, cache));
        }
        
        return ++cache[row][col];
    }
}