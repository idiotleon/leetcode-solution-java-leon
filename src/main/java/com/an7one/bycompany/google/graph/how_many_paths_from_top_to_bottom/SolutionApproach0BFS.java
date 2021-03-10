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
 * Solution is not verified
 */
package com.an7one.bycompany.google.graph.how_many_paths_from_top_to_bottom;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SolutionApproach0BFS {
    private static final int WALL = 0;
    private static final int PATH = 1;

    private static final int[] DIRS = {0, -1, 0, 1, 0};
    private int NR, NC;

    private int count;

    public int countAllPaths(int[][] matrix){
        // sanity check
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        NR = matrix.length;
        NC = matrix[0].length;

        // to check wether the top or bottom contains any path
        if(!containsAnyPath(matrix[0]) || !containsAnyPath(matrix[NR - 1])) return 0;

        this.count = 0;

        for(int col = 0; col < NC; col++){
            if(matrix[0][col] == PATH){
                bfs(matrix, 0, col);
            }
        }

        return count;
    }

    private void bfs(int[][] matrix, int row, int col){
        // to intialize the queue with the bottom row
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{row, col});
        Set<Integer> seen = new HashSet<Integer>();

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                seen.add(index(cur));
                if(cur[0] == NR - 1) {
                    count++;
                    break;
                }

                for(int d = 0; d < 4; d++){
                    int r = cur[0] + DIRS[d], c = cur[1] + DIRS[d + 1];
                    if(r < 0 || c < 0 || r >= NR || c >= NC || seen.contains(index(r, c)) || matrix[r][c] == WALL) continue;

                    queue.add(new int[]{r, c});
                }
            }
        }
    }

    private int index(int[] pos){
        return index(pos[0], pos[1]);
    }

    private int index(int row, int col){
        return row * NC + col;
    }

    private boolean containsAnyPath(int[] row){
        for(int num : row){
            if(num == PATH){
                return true;
            }
        }

        return false;
    }
}