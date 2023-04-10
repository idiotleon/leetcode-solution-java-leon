/**
 * path from top row to bottom row
 * given a 0/1 matrix, 0 means wall, 1 means path, 
 * find how many paths from top row to bottom row.
 * 
 * 1 0 1
 * 1 1 0
 * 1 1 0
 * output： 2
 * 
 * 
 * 1 0 1 1
 * 1 1 1 1
 * 0 0 0 1
 * 
 * output： 5
 * 
 * Time Complexity:
 * Space Compelxity:
 * 
 * 
 * follow up:
 *  to print out all paths
 * 
 * 
 * solution is NOT verified
 */
package com.idiotleon.bycompany.google.graph.how_many_paths_from_top_to_bottom;

public class SolutionApproach0DFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    private static final int WALL = 0;
    private static final int PATH = 1;

    private int NR, NC;
    private int count;

    public int countAllPaths(int[][] matrix){
        // sanity check
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        this.NR = matrix.length;
        this.NC = matrix[0].length;

        this.count = 0;
        boolean[][] visited = new boolean[NR][NC];
        for(int col = 0; col < NC; col++){
            if(matrix[0][col] == PATH){
                backtrack(matrix, visited, 0, col);;
            }
        }

        return count;
    }

    private void backtrack(int[][] matrix, boolean[][] visited, int row, int col){
        if(row < 0 || row >= NR || col < 0 || col >= NC || visited[row][col] || matrix[row][col] == WALL) return;

        if(row == NR - 1) {
            count++;
            return;
        }

        visited[row][col] = true;

        for(int d = 0; d < 4; d++){
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            backtrack(matrix, visited, r, c);
        }

        visited[row][col] = false;
    }
}