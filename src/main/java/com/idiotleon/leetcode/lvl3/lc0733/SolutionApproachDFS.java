/**
 * https://leetcode.com/problems/flood-fill/
 * 
 * Time Complexity: O(MN)
 * Space Complexity: O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0733;

public class SolutionApproachDFS {
    final static int[] DIRS = {0, 1, 0, -1, 0};
    private int NR, NC;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        
        NR = image.length;
        NC = image[0].length;
        
        int color = image[sr][sc];
        
        // Note: dfs once only
        // Note: Be careful with the old "color"
        dfs(image, sr, sc, color, newColor);
        // Note: Make sure which one, image[sr][sc] or color should be passed in,
        // while in this case, both should work.
        // dfs(image, sr, sc, image[sr][sc], newColor);
        
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int color, int newColor){
        if(row < 0 || row >= NR || col < 0 || col >= NC || image[row][col] != color) return;
        
        image[row][col] = newColor;
        
        for(int d = 0; d < 4; d++){
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            dfs(image, r, c, color, newColor);
        }
    }
}