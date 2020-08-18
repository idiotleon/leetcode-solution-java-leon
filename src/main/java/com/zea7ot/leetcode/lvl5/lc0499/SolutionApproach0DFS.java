/**
 * https://leetcode.com/problems/the-maze-iii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/the-maze-iii/discuss/97832/Clear-Java-Accepted-DFS-Solution-with-Explanation
 */
package com.zea7ot.leetcode.lvl5.lc0499;

public class SolutionApproach0DFS {
    private static int[][] DIRS = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    // to strictly align with DIRS(int[][])
    private static char[] MOVES = {'d', 'r', 'l', 'u'};
    private int minSteps, M, N;
    private String ans;
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        this.M = maze.length;
        this.N = maze[0].length;
        this.minSteps = Integer.MAX_VALUE;
        this.ans = null;
        boolean[][] visited = new boolean[M][N];
        visited[ball[0]][ball[1]] = true;
        
        backtrack(maze, hole, visited, ball[0], ball[1], "", 0);

        return ans == null ? "impossible" : ans;
    }
    
    private void backtrack(int[][] maze, 
                           int[] hole, 
                           boolean[][] visited, 
                           int row, 
                           int col, 
                           String route, 
                           int steps){
        if(steps > minSteps) return;
        if(row == hole[0] && col == hole[1]){
            if(steps == minSteps && route.compareTo(ans) < 0){
                ans = route;
            }else if(steps < minSteps){
                minSteps = steps;
                ans = route;
            }
            
            visited[row][col] = false;
            return;
        }
        
        for(int d = 0; d < 4; d++){
            int r = row , c = col;
            while(r + DIRS[d][0] >= 0 && r + DIRS[d][0] < M 
                  && c + DIRS[d][1] >= 0 && c + DIRS[d][1] < N 
                  && maze[r + DIRS[d][0]][c + DIRS[d][1]] != 1){
                r += DIRS[d][0];
                c += DIRS[d][1];
                if(r == hole[0] && c == hole[1] || visited[r][c]) break;
            }
            
            if(visited[r][c] || maze[r][c] == 1) continue;
            visited[r][c] = true;
            backtrack(maze, hole, visited, r, c, route + MOVES[d], steps + Math.abs(r - row) + Math.abs(c - col));
            visited[r][c] = false;
        }
    }
}