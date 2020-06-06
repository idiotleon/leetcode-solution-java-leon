/**
 * https://leetcode.com/problems/flood-fill/
 * 
 * Time Complexity: O(MN)
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl3.lc0733;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproachBFS {
    private static final int[] DIRS = {0, 1, 0, -1, 0};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) return image;
        
        final int NR = image.length, NC = image[0].length;
        
        int color = image[sr][sc];
        if(color == newColor) return image;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{sr, sc});
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int row = cur[0], col = cur[1];
                image[row][col] = newColor;
                
                for(int d = 0; d < 4; d++){
                    int r = row + DIRS[d], c = col + DIRS[d + 1];
                    if(r >= 0 && r < NR && c >= 0 && c < NC && image[r][c] == color){
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        
        return image;
    }
}