/**
 * https://leetcode.com/problems/01-matrix/
 */
package main.java.lcidiot.lc.lvl3.lc0542;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproachBFS {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int[][] updateMatrix(int[][] matrix) {
        // sanity check
        if(matrix == null || matrix.length == 0) return matrix;
        
        int nr = matrix.length, nc = matrix[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                if(matrix[row][col] == 0){
                    queue.add(new int[]{row, col});
                }else{
                    matrix[row][col] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0], col = cur[1];
            for(int[] dir : DIRS){
                int r = row + dir[0], c = col + dir[1];
                
                if(r < 0 || r >= nr || c < 0 || c >= nc) continue;
                
                if(matrix[r][c] == Integer.MAX_VALUE){
                    queue.add(new int[]{r, c});
                    matrix[r][c] = matrix[row][col] + 1;
                }
            }
        }
        
        return matrix;
    }
}