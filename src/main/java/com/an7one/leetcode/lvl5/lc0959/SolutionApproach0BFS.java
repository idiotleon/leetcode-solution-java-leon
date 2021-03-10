/**
 * https://leetcode.com/problems/regions-cut-by-slashes/
 * 
 * Time Complexity: O((N * FACTOR) ^ 2) ~ O(N ^ 2)
 * Space Complexity: O((N * FACTOR) ^ 2) ~ O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/regions-cut-by-slashes/discuss/205674/C++-with-picture-DFS-on-upscaled-grid/209661
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/number-of-islands/
 *  https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */
package com.an7one.leetcode.lvl5.lc0959;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproach0BFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    
    public int regionsBySlashes(String[] grid) {
        final int N = grid.length, FACTOR = 3;
        int[][] matrix = new int[N * FACTOR][N * FACTOR];
        
        // to build the matrix/graph
        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                int startRow = row * FACTOR, startCol = col * FACTOR;
                if(grid[row].charAt(col) == '/'){
                    for(int k = 0; k < FACTOR; k++){
                        for(int m = 0; m < FACTOR; m++){
                            if(k + m == FACTOR - 1){
                                matrix[startRow + k][startCol + m] = 1;
                            }
                        }
                    }
                }else if(grid[row].charAt(col) == '\\'){
                    for(int k = 0; k < FACTOR; k++){
                        for(int m = 0; m < FACTOR; m++){
                            if(k == m){
                                matrix[startRow + k][startCol + m] = 1;
                            }
                        }
                    }
                }
            }
        }
        
        int count = 0;
        // to BFS to find '0' regions
        for(int row = 0; row < N * FACTOR; row++){
            for(int col = 0; col < N * FACTOR; col++){
                if(matrix[row][col] == 0){
                    bfs(matrix, row, col);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void bfs(int[][] matrix, int row, int col){
        final int N = matrix.length;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{row, col});
        matrix[row][col] = 1;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int d = 0; d < 4; d++){
                int r = cur[0] + DIRS[d], c = cur[1] + DIRS[d + 1];
                if(r < 0 || r >= N || c < 0 || c >= N || matrix[r][c] != 0) continue;
                queue.offer(new int[]{r, c});
                matrix[r][c] = 1;
            }
        }
    }
}